package dev.acaica.server.net.packet.`in`.login

import dev.acaica.server.net.CommunicationState
import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.packet.PacketInCompanion
import dev.acaica.server.net.packet.PacketInformation
import dev.acaica.server.net.types.PacketStringUtil
import java.io.ByteArrayInputStream

@PacketInformation(
        packetID = 0x00,
        state = CommunicationState.LOGIN,
        components = ["name"]
)
class LoginStart : Packet {
    var name: String = ""
}