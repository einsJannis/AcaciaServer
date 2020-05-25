package dev.acaica.server.net.packet.`in`.play

import dev.acaica.server.net.CommunicationState
import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.packet.PacketInformation
import dev.acaica.server.net.types.PacketPosition

@PacketInformation (
        packetID = 0x29,
        state = CommunicationState.PLAY,
        components = ["location", "line1", "line2", "line3", "line4"]
)

class UpdateSign : Packet {
    val location: PacketPosition = PacketPosition(0)
    val line1: String = ""
    val line2: String = ""
    val line3: String = ""
    val line4: String = ""
}