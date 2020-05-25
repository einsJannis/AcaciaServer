package dev.acaica.server.net.packet.`in`.play

import dev.acaica.server.net.CommunicationState
import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.packet.PacketInformation

@PacketInformation (
        packetID = 0x16,
        state = CommunicationState.PLAY,
        components = ["leftPaddle", "rightPaddle"]
)

class SteerBoat : Packet {
    val leftPaddle: Boolean = false
    val rightPaddle: Boolean = false
}