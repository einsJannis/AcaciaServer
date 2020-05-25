package dev.acaica.server.net.packet.out.play

import dev.acaica.server.net.CommunicationState
import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.packet.PacketInformation
import dev.acaica.server.net.types.VarInt

@PacketInformation(
        packetID = 0x25,
        state = CommunicationState.PLAY,
        components = ["chunkX", "chunkY", "skyLightMask", "blockLightMasks", "emptySkyLightMask", "emptyBlockLightMask", "skyLightArrays", "blockLightArrays"]
)
class UpdateLight(
        val chunkX: VarInt,
        val chunkY: VarInt,
        val skyLightMask: VarInt,
        val blockLightMask: VarInt,
        val emptySkyLightMask: VarInt,
        val emptyBlockLightMask: VarInt,
        val skyLightArrays: Array<Pair<VarInt, Array<Byte>>>,
        val blockLightArrays: Array<Pair<VarInt, Array<Byte>>>
) : Packet