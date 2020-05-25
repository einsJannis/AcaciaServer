package dev.acaica.server.net.packet.out.play

import dev.acaica.server.net.CommunicationState
import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.packet.PacketInformation
import dev.acaica.server.net.types.PacketPosition
import dev.acaica.server.net.types.VarInt

@PacketInformation(
        packetID = 0x09,
        state = CommunicationState.PLAY,
        components = ["entityID", "location", "destroyStage"]
)
class BlockBreakAnimation(val entityID: VarInt, val location: PacketPosition, val destroyStage: Byte) : Packet
