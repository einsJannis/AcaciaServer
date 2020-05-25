package dev.acaica.server.net.packet.out.play

import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.types.PacketPosition
import dev.acaica.server.net.types.VarInt

class AcknowledgePlayerDigging(val location: PacketPosition, val block: VarInt, val status: VarInt, val successful: Boolean) : Packet