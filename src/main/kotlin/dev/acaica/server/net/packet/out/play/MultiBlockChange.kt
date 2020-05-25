package dev.acaica.server.net.packet.out.play

import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.types.MultiBlockRecord
import dev.acaica.server.net.types.VarInt

class MultiBlockChange(val chunkX: Int, val chunkY: Int, val recordCount: VarInt, val record: Array<MultiBlockRecord>) : Packet