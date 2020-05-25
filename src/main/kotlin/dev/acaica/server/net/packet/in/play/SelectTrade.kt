package dev.acaica.server.net.packet.`in`.play

import dev.acaica.server.net.CommunicationState
import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.packet.PacketInformation
import dev.acaica.server.net.types.VarInt

@PacketInformation (
        packetID = 0x21,
        state = CommunicationState.PLAY,
        components = ["selectedSlots"]
)

class SelectTrade : Packet {
    val selectedSlot: VarInt = VarInt(byteArrayOf())
}