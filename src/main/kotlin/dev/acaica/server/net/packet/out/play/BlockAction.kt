package dev.acaica.server.net.packet.out.play

import dev.acaica.server.net.CommunicationState
import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.packet.PacketInformation
import dev.acaica.server.net.types.PacketPosition
import dev.acaica.server.net.types.VarInt

@PacketInformation(
        packetID = 0x0B,
        state = CommunicationState.PLAY,
        components = ["location", "actionID", "actionParam", "blockType"]
)
class BlockAction(val location: PacketPosition, val actionID: UByte, val actionParam: UByte, val blockType: VarInt) : Packet
