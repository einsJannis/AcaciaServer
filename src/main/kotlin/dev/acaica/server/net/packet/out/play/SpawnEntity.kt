package dev.acaica.server.net.packet.out.play

import dev.acaica.server.net.CommunicationState
import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.packet.PacketInformation
import dev.acaica.server.net.types.VarInt
import dev.acaica.server.types.Position
import dev.acaica.server.net.types.Angle
import dev.einsjannis.math.vector.Vector3D
import java.util.*

@PacketInformation(
        packetID = 0x00,
        state = CommunicationState.PLAY,
        components = ["entityID", "objectUUID", "type", "x", "y", "z", "pitch", "yaw", "velocityX", "velocityY", "velocityZ"]
)
class SpawnEntity(
        val entityID: VarInt,
        val objectUUID: UUID,
        val type: VarInt,
        val x: Double,
        val y: Double,
        val z: Double,
        val pitch: Angle,
        val yaw: Angle,
        val velocityX: Short,
        val velocityY: Short,
        val velocityZ: Short
) : Packet {
    constructor(
            entityID: VarInt,
            objectUUID: UUID,
            type: VarInt,
            position: Position,
            pitch: Angle,
            yaw: Angle,
            velocity: Vector3D
    ) : this(
            entityID,
            objectUUID,
            type,
            position.x,
            position.y,
            position.z,
            pitch,
            yaw,
            velocity.x.toShort(),
            velocity.y.toShort(),
            velocity.z.toShort()
    )
}