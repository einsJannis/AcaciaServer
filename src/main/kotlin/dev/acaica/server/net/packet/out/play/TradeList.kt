package dev.acaica.server.net.packet.out.play

import dev.acaica.server.net.CommunicationState
import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.packet.PacketInformation
import dev.acaica.server.net.types.Trade
import dev.acaica.server.net.types.VarInt

@PacketInformation(
        packetID = 0x28,
        state = CommunicationState.PLAY,
        components = ["windowID", "size", "trades", " "]
)
class TradeList(
        val windowID: VarInt,
        val size: Byte,
        val trades: Array<Trade>,
        val villagerLevel: VarInt,
        val experience: VarInt,
        val isRegularVillager: Boolean,
        val canRestock: Boolean
) : Packet