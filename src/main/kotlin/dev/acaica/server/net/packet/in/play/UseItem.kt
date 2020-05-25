package dev.acaica.server.net.packet.`in`.play

import dev.acaica.server.net.CommunicationState
import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.packet.PacketInformation
import dev.acaica.server.net.types.VarInt

@PacketInformation (
        packetID = 0x2D,
        state = CommunicationState.PLAY,
        components = ["hand"]
)

class UseItem : Packet {
    val hand: VarInt = VarInt(byteArrayOf())
}