package dev.acaica.server.net.packet.out.play

import dev.acaica.server.net.CommunicationState
import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.packet.PacketInformation
import dev.acaica.server.net.types.Angle
import dev.acaica.server.net.types.VarInt
import dev.acaica.server.types.Position
import java.util.*

@PacketInformation(
        packetID = 0x05,
        state = CommunicationState.PLAY,
        components = ["entityID", "playerUUID", "x", "y", "z", "yaw", "pitch"]
)
class SpawnPlayer(
        val entityID: VarInt,
        val playerUUID: UUID,
        val x: Double,
        val y: Double,
        val z: Double,
        val yaw: Angle,
        val pitch: Angle
) : Packet {
    constructor(
            entityID: VarInt,
            playerUUID: UUID,
            position: Position,
            yaw: Angle,
            pitch: Angle
    ) : this(
            entityID,
            playerUUID,
            position.x,
            position.y,
            position.z,
            yaw,
            pitch
    )
}
