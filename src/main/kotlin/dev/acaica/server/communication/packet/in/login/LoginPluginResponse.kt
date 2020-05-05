package dev.acaica.server.communication.packet.`in`.login

import dev.acaica.server.communication.packet.Packet
import dev.acaica.server.communication.types.VarInt
import java.io.ByteArrayInputStream

class LoginPluginResponse(messageID: VarInt, successful: Boolean, data: ByteArray?) : Packet() {
    companion object {
        fun build(data: ByteArray): LoginPluginResponse {
            val inputStream = ByteArrayInputStream(data)
            val messageID = VarInt.readFromInputStream(inputStream)
            val successful: Boolean = inputStream.read() == 0x01
            val bdata: ByteArray? = if (messageID.toByteArray().size + 1 < data.size) inputStream.readAllBytes() else null
            return LoginPluginResponse(messageID, successful, bdata)
        }
    }
}