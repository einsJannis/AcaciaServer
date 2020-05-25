package dev.acaica.server.net.packet.`in`.play

import dev.acaica.server.net.CommunicationState
import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.packet.PacketInformation
import java.util.*

@PacketInformation (
        packetID = 0x2B,
        state = CommunicationState.PLAY,
        components = ["targetPlayer"]
)

class Spectate : Packet {
    val targetPlayer: UUID = UUID.fromString("")
}