package dev.acaica.server.net.packet.out.play

import dev.acaica.server.net.CommunicationState
import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.packet.PacketInformation
import dev.acaica.server.net.types.Angle
import dev.acaica.server.net.types.VarInt

@PacketInformation(
        packetID = 0x2B,
        state = CommunicationState.PLAY,
        components = ["entityID", "yaw", "pitch", "onGround"]
)
class EntityRotation(val entityID: VarInt, val yaw: Angle, val pitch: Angle, val onGround: Boolean) : Packet