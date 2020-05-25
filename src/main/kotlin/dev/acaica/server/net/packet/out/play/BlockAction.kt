package dev.acaica.server.net.packet.out.play

import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.types.PacketPosition
import dev.acaica.server.net.types.VarInt

class BlockAction(val location: PacketPosition, val actionID: UByte, val actionParam: UByte, val blockType: VarInt) : Packet
