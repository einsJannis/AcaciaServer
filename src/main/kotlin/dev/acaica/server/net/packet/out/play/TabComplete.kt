package dev.acaica.server.net.packet.out.play

import dev.acaica.server.net.CommunicationState
import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.packet.PacketInformation
import dev.acaica.server.net.types.VarInt

@PacketInformation(
        packetID = 0x11,
        state = CommunicationState.PLAY,
        components = ["id", "start", "length", "count"]
)
class TabComplete(val id: VarInt, val start: VarInt, val length: VarInt, val count: VarInt) : Packet