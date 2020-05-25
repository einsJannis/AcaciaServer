package dev.acaica.server.net.packet.out.play

import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.types.PacketPosition
import dev.acaica.server.net.types.VarInt

class BlockChange(val location: PacketPosition, val blockID: VarInt) : Packet
