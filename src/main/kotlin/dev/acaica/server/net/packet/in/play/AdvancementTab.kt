package dev.acaica.server.net.packet.`in`.play

import dev.acaica.server.net.CommunicationState
import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.packet.PacketInformation
import dev.acaica.server.net.types.VarInt
import dev.acaica.server.types.Identifier

@PacketInformation (
        packetID = 0x20,
        state = CommunicationState.PLAY,
        components = ["action", "tabID"]
)

class AdvancementTab : Packet {
    val action: VarInt = VarInt(byteArrayOf())
    val tabID: Identifier? = null
}