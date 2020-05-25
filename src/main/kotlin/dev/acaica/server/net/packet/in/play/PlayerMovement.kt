package dev.acaica.server.net.packet.`in`.play

import dev.acaica.server.net.CommunicationState
import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.packet.PacketInformation

@PacketInformation (
        packetID = 0x14,
        state = CommunicationState.PLAY,
        components = ["onGround"]
)

class PlayerMovement : Packet {
    val onGround: Boolean = false
}