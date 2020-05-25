package dev.acaica.server.net.packet.`in`.play

import dev.acaica.server.net.CommunicationState
import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.packet.PacketInformation

@PacketInformation (
        packetID = 0x11,
        state = CommunicationState.PLAY,
        components = ["x", "feetY", "z", "onGround"]
)

class PlayerPosition : Packet {
    val x: Double = 0.0
    val feetY: Double = 0.0
    val z: Double = 0.0
    val onGround: Boolean = false
}