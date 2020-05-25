package dev.acaica.server.net.packet.out.play

import dev.acaica.server.net.CommunicationState
import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.packet.PacketInformation
import dev.acaica.server.net.types.VarInt

@PacketInformation(
        packetID = 0x18,
        state = CommunicationState.PLAY,
        components = ["itemID", "cooldownTicks"]
)
class SetCooldown(val itemID: VarInt, val cooldownTicks: VarInt) : Packet