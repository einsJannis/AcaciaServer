package dev.acaica.server.net.packet.out.play

import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.types.NBT
import dev.acaica.server.net.types.PacketPosition

class BlockEntityData(val location: PacketPosition, val action: UByte, val nbtData: NBT) : Packet