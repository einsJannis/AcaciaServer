package dev.acaica.server.net.handler.login

import com.google.gson.Gson
import dev.acaica.server.AcaciaServer
import dev.acaica.server.JSONChat
import dev.acaica.server.Logger
import dev.acaica.server.entity.Player
import dev.acaica.server.event.Event
import dev.acaica.server.event.PlayerLoginEvent
import dev.acaica.server.net.Client
import dev.acaica.server.net.handler.Handler
import dev.acaica.server.net.netty.EncryptionHandler
import dev.acaica.server.net.packet.`in`.login.EncryptionResponse
import dev.acaica.server.net.packet.out.login.Disconnect
import dev.acaica.server.net.packet.out.login.LoginSuccess
import dev.acaica.server.net.packet.out.play.JoinGame
import dev.acaica.server.net.types.VarInt
import dev.acaica.server.types.Position
import dev.acaica.server.types.Rotation
import java.math.BigInteger
import java.net.URL
import java.nio.charset.Charset
import java.security.MessageDigest
import java.util.*
import javax.crypto.Cipher
import javax.crypto.SecretKey
import javax.crypto.spec.SecretKeySpec

object EncryptionResponseHandler : Handler<EncryptionResponse> {
    override fun handle(client: Client, packet: EncryptionResponse) {
        val rsa: Cipher
        try {
            rsa = Cipher.getInstance("RSA")
        } catch (exce: Exception) {
            exce.printStackTrace()
            //TODO: Exception handling
            return
        }
        val sharedSecret: SecretKey
        try {
            rsa.init(Cipher.DECRYPT_MODE, AcaciaServer.keyPair.private)
            sharedSecret = SecretKeySpec(rsa.doFinal(packet.sharedSecret), "AES")
        } catch (exce: Exception) {
            exce.printStackTrace()
            //TODO: Exception handling
            return
        }
        val verifyToken: ByteArray
        try {
            rsa.init(Cipher.DECRYPT_MODE, AcaciaServer.keyPair.private)
            verifyToken = rsa.doFinal(packet.verifyToken)
        } catch (exce: Exception) {
            exce.printStackTrace()
            //TODO: Exception handling
            return
        }
        if (!client.verifyToken.contentEquals(verifyToken)) {
            client.sendPacket(Disconnect(JSONChat("Wrong verify token")))
        }
        client.channel.pipeline().addAfter("framingHandler", "encryption", EncryptionHandler(sharedSecret))
        val hash: String
        try {
            val digest = MessageDigest.getInstance("SHA-1")
            digest.update(sharedSecret.encoded)
            digest.update(AcaciaServer.keyPair.public.encoded)
            hash = BigInteger(digest.digest()).toString(16)
        } catch (exce: Exception) {
            exce.printStackTrace()
            //TODO: Exception handling
            return
        }
        Logger.debug("hash: $hash")
        val url = "https://sessionserver.mojang.com/session/minecraft/hasJoined?username=${client.username}&serverId=${hash}"
        val response = Gson().fromJson(URL(url).readText(charset("UTF-8")), HasJoinedResponse::class.java)
        val uuidString = "${response.id.subSequence(0..6)}-${response.id.subSequence(7..10)}-${response.id.subSequence(11..14)}-${response.id.subSequence(15..19)}-${response.id.subSequence(20..31)}"
        val uuid = UUID.fromString(uuidString)
        val username = response.name
        val skin = response.properties.find { it.name == "textures" }!!.value.toByteArray(Charset.forName("UTF-8"))
        val player = Player(uuid, username, client, skin, 20, Position(0.0,0.0,0.0), Rotation(0.0, 0.0))
        Event.emit(PlayerLoginEvent(player))
        client.sendPacket(LoginSuccess(player.uniqueId.toString(), player.username))
        client.sendPacket(JoinGame(0, 0.toUByte(), 0, 0, 0.toUByte(), "flat", VarInt.fromInt(8), false, false))
    }
    class HasJoinedResponse {
        val id: String = ""
        val name: String = ""
        val properties: Array<Properties> = arrayOf()
        class Properties {
            val name: String = ""
            val value: String = ""
            val signature: String = ""
        }
    }
}
