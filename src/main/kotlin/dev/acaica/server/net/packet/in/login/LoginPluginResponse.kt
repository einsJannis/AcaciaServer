package dev.acaica.server.net.packet.`in`.login

import dev.acaica.server.net.CommunicationState
import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.packet.PacketInCompanion
import dev.acaica.server.net.packet.PacketInformation
import dev.acaica.server.net.types.VarInt
import java.io.ByteArrayInputStream

@PacketInformation(
        packetID = 0x02,
        state = CommunicationState.LOGIN,
        components = ["messageID", "successful", "data"]
)
class LoginPluginResponse : Packet {
    var messageID: VarInt = VarInt(byteArrayOf())
    var successful: Boolean = false
    var data: ByteArray? = byteArrayOf()
}