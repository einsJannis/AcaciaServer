package dev.acaica.server.net.packet.out.play

import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.types.Angle
import dev.acaica.server.net.types.VarInt
import dev.acaica.server.types.Position
import dev.einsjannis.math.vector.Vector3D
import java.util.*

class SpawnLivingEntity(
        val entityID: VarInt,
        val entityUUID: UUID,
        val type: VarInt,
        val x: Double,
        val y: Double,
        val z: Double,
        val yaw: Angle,
        val pitch: Angle,
        val headPitch: Angle,
        val velocityX: Short,
        val velocityY: Short,
        val velocityZ: Short
) : Packet {
    constructor(
            entityID: VarInt,
            entityUUID: UUID,
            type: VarInt,
            position: Position,
            yaw: Angle,
            pitch: Angle,
            headPitch: Angle,
            velocity: Vector3D
    ) : this(
            entityID,
            entityUUID,
            type,
            position.x,
            position.y,
            position.z,
            yaw,
            pitch,
            headPitch,
            velocity.x.toShort(),
            velocity.y.toShort(),
            velocity.z.toShort()
    )
}