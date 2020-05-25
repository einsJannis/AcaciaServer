package dev.acaica.server.net.packet.out.play

import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.types.VarInt

class Statistics(val count: VarInt, val statistic: Array<Pair<VarInt, VarInt>>, val value: VarInt) : Packet