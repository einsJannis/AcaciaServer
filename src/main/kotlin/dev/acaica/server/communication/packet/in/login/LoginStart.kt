package dev.acaica.server.communication.packet.`in`.login

import dev.acaica.server.communication.packet.Packet
import dev.acaica.server.communication.types.PacketStringUtil
import java.io.ByteArrayInputStream

class LoginStart(val name: String) : Packet() {
    companion object {
        fun build(data: ByteArray): LoginStart {
            return LoginStart(PacketStringUtil.readFromInputStream(ByteArrayInputStream(data)))
        }
    }
}