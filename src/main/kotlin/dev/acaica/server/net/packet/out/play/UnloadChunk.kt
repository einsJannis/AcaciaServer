package dev.acaica.server.net.packet.out.play

import dev.acaica.server.net.CommunicationState
import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.packet.PacketInformation

@PacketInformation(
        packetID = 0x1E,
        state = CommunicationState.PLAY,
        components = ["chunkX", "chunkY"]
)
class UnloadChunk(val chunkX: Int, val chunkY: Int) : Packet