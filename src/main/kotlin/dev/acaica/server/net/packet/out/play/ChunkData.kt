package dev.acaica.server.net.packet.out.play

import dev.acaica.server.net.CommunicationState
import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.packet.PacketInformation
import dev.acaica.server.net.types.NBT
import dev.acaica.server.net.types.VarInt

@PacketInformation(
        packetID = 0x22,
        state = CommunicationState.PLAY,
        components = ["chunkX", "chunkY", "fullChunk", "primaryBitMask", "height", "biomes", "size", "data", "numberOfBlockEntities", "blockEntities"]
)
class ChunkData(
        val chunkX: Int,
        val chunkY: Int,
        val fullChunk: Boolean,
        val primaryBitMask: VarInt,
        val heightMap: NBT,
        val biomes: Array<Int>,
        val size: VarInt,
        val data: ByteArray,
        val numberOfBlockEntities: VarInt,
        val blockEntities: Array<NBT>
) : Packet