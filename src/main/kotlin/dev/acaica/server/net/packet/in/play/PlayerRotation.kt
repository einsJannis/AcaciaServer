package dev.acaica.server.net.packet.`in`.play

import dev.acaica.server.net.CommunicationState
import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.packet.PacketInformation

@PacketInformation (
        packetID = 0x13,
        state = CommunicationState.PLAY,
        components = ["yaw", "pitch", "onGround"]
)

class PlayerRotation : Packet {
    val yaw: Float = 0f
    val pitch: Float = 0f
    val onGround: Boolean = false
}