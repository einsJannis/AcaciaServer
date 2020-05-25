package dev.acaica.server.net.handler.login

import dev.acaica.server.AcaciaServer
import dev.acaica.server.net.Client
import dev.acaica.server.net.handler.Handler
import dev.acaica.server.net.packet.`in`.login.EncryptionResponse
import dev.acaica.server.net.packet.`in`.login.LoginStart
import dev.acaica.server.net.packet.out.login.EncryptionRequest

object LoginStartHandler : Handler<LoginStart> {
    override fun handle(client: Client, packet: LoginStart) {
        client.username = packet.name
        client.sendPacket(EncryptionRequest(AcaciaServer.keyPair.public.encoded, client.verifyToken))
    }
}