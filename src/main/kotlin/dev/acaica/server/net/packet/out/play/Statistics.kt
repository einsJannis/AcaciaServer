package dev.acaica.server.net.packet.out.play

import dev.acaica.server.net.CommunicationState
import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.packet.PacketInformation
import dev.acaica.server.net.types.VarInt

@PacketInformation(
        packetID = 0x07,
        state = CommunicationState.PLAY,
        components = ["count", "statistic", "value"]
)
class Statistics(val count: VarInt, val statistic: Array<Pair<VarInt, VarInt>>, val value: VarInt) : Packet