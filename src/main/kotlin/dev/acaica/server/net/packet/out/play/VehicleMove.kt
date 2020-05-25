package dev.acaica.server.net.packet.out.play

import dev.acaica.server.net.CommunicationState
import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.packet.PacketInformation
import dev.acaica.server.net.types.Angle

@PacketInformation(
        packetID = 0x2D,
        state = CommunicationState.PLAY,
        components = ["x", "y", "z", "yaw", "pitch"]
)
class VehicleMove(val x: Double, val y: Double, val z: Double, val yaw: Angle, val pitch: Angle) : Packet