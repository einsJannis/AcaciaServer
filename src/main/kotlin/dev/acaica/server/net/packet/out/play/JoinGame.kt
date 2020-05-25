package dev.acaica.server.net.packet.out.play

import dev.acaica.server.net.CommunicationState
import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.packet.PacketInformation
import dev.acaica.server.net.types.VarInt

@PacketInformation(
        packetID = 0x26,
        state = CommunicationState.PLAY,
        components = ["entityID", "gamemode", "dimension", "hashedSeed", "maxPlayers", "levelType", "viewDistance", "reducedDebugInfo", "enableRespawnScreen"]
)
class JoinGame @ExperimentalUnsignedTypes constructor(
        val entityID: Int,
        val gamemode: UByte,
        val dimension: Int,
        val hashedSeed: Long,
        val maxPlayers: UByte,
        val levelType: String,
        val viewDistance: VarInt,
        val reducedDebugInfo: Boolean,
        val enableRespawnScreen: Boolean
) : Packet