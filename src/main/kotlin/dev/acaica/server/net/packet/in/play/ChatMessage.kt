package dev.acaica.server.net.packet.`in`.play

import dev.acaica.server.net.CommunicationState
import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.packet.PacketInformation

@PacketInformation (
        packetID = 0x03,
        state = CommunicationState.PLAY,
        components = ["message"]
)

class ChatMessage : Packet {
    val message: String = ""
}