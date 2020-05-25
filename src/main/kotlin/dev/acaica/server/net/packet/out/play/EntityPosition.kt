package dev.acaica.server.net.packet.out.play

import dev.acaica.server.net.CommunicationState
import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.packet.PacketInformation
import dev.acaica.server.net.types.VarInt

@PacketInformation(
        packetID = 0x29,
        state = CommunicationState.PLAY,
        components = []
)
class EntityPosition(val entityID: VarInt, val deltaX: Short, val deltaY: Short, val deltaZ: Short, val onGround: Boolean) : Packet