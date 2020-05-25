package dev.acaica.server.net.packet.out.play

import dev.acaica.server.net.CommunicationState
import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.packet.PacketInformation
import dev.acaica.server.net.types.PacketPosition
import dev.acaica.server.net.types.VarInt
import java.util.*

@PacketInformation(
        packetID = 0x04,
        state = CommunicationState.PLAY,
        components = ["entityID", "entityUUID", "motive", "location", "direction"]
)
class SpawnPainting(val entityID: VarInt, val entityUUID: UUID, val motive: VarInt, val location: PacketPosition, val direction: Byte) : Packet