package dev.acaica.server.net.packet.out.play

import dev.acaica.server.net.CommunicationState
import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.packet.PacketInformation
import dev.acaica.server.net.types.MultiBlockRecord
import dev.acaica.server.net.types.VarInt

@PacketInformation(
        packetID = 0x10,
        state = CommunicationState.PLAY,
        components = ["chunkX", "chunkY", "recordCount", "record"]
)
class MultiBlockChange(val chunkX: Int, val chunkY: Int, val recordCount: VarInt, val record: Array<MultiBlockRecord>) : Packet