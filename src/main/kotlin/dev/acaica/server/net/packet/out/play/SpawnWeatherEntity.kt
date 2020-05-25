package dev.acaica.server.net.packet.out.play

import dev.acaica.server.net.CommunicationState
import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.packet.PacketInformation
import dev.acaica.server.net.types.VarInt
import dev.acaica.server.types.Position

@PacketInformation(
        packetID = 0x02,
        state = CommunicationState.PLAY,
        components = ["entityID", "type", "x", "y", "z"]
)
class SpawnWeatherEntity(val entityID: VarInt, val type: Byte, val x: Double, val y: Double, val z: Double) : Packet {
    constructor(entityID: VarInt, type: Byte, position: Position) : this(entityID, type, position.x, position.y, position.z)
}