package dev.acaica.server.net.packet.`in`.play

import dev.acaica.server.net.CommunicationState
import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.packet.PacketInformation
import dev.acaica.server.net.types.PacketPosition
import dev.acaica.server.types.Identifier
import dev.acaica.server.types.Position

@PacketInformation (
        packetID = 0x27,
        state = CommunicationState.PLAY,
        components = ["location", "attachmentType", "targetPool", "finalState"]
)

class UpdateJigsawBlock : Packet {
    val location: PacketPosition = PacketPosition(0)
    val attachmentType: Identifier = Identifier("", "")
    val targetPool: Identifier = Identifier("", "")
    val finalState: String = ""
}