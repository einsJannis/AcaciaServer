package dev.acaica.server.net.packet.`in`.play

import dev.acaica.server.net.CommunicationState
import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.packet.PacketInformation
import dev.acaica.server.net.types.VarInt

@PacketInformation (
        packetID = 0x06,
        state = CommunicationState.PLAY,
        components = ["transactionID", "text"]
)

class TabComplete : Packet {
    val transactionID: VarInt = VarInt(byteArrayOf())
    val text: String = ""
}