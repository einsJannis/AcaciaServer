package dev.acaica.server.net.packet.out.play

import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.types.VarInt
import dev.acaica.server.types.Position

class SpawnExperienceOrb(val entityID: VarInt, val x: Double, val y: Double, val z: Double, val count: Short) : Packet {
     constructor(entityID: VarInt, position: Position, count: Short) : this(entityID, position.x, position.y, position.z, count)
}