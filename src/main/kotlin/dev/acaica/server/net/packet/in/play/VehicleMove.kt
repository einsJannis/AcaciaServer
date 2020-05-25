package dev.acaica.server.net.packet.`in`.play

import dev.acaica.server.net.CommunicationState
import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.packet.PacketInformation

@PacketInformation (
        packetID = 0x15,
        state = CommunicationState.PLAY,
        components = ["x", "y", "z", "yaw", "pitch"]
)

class VehicleMove : Packet {
    val x: Double = 0.0
    val y: Double = 0.0
    val z: Double = 0.0
    val yaw: Float = 0f
    val pitch: Float = 0f
}