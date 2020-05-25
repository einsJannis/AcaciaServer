package dev.acaica.server.net.packet.`in`.play

import dev.acaica.server.net.CommunicationState
import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.packet.PacketInformation

@PacketInformation (
        packetID = 0x12,
        state = CommunicationState.PLAY,
        components = ["x", "feetY", "z", "yaw", "pitch", "onGround"]
)

class PlayerPositionAndRotation : Packet {
    val x: Double = 0.0
    val feetY: Double = 0.0
    val z: Double = 0.0
    val yaw: Float = 0f
    val pitch: Float = 0f
    val onGround: Boolean = false
}