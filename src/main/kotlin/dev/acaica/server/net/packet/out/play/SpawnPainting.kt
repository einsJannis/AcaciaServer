package dev.acaica.server.net.packet.out.play

import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.types.PacketPosition
import dev.acaica.server.net.types.VarInt
import java.util.*

class SpawnPainting(val entityID: VarInt, val entityUUID: UUID, val motive: VarInt, val location: PacketPosition, val direction: Byte) : Packet