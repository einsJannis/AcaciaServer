package dev.acaica.server.net.packet.out.play

import dev.acaica.server.net.CommunicationState
import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.packet.PacketInformation
import dev.acaica.server.net.types.Angle
import dev.acaica.server.net.types.VarInt

@PacketInformation(
        packetID = 0x2A,
        state = CommunicationState.PLAY,
        components = ["entityID", "deltaX", "deltaZ", "yaw", "pitch", "onGround"]
)
class EntityPositionAndRotation(
        val entityID: VarInt,
        val deltaX: Short,
        val deltaY: Short,
        val deltaZ: Short,
        val yaw: Angle,
        val pitch: Angle,
        val onGround: Boolean
) : Packet