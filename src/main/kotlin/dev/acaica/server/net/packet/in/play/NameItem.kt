package dev.acaica.server.net.packet.`in`.play

import dev.acaica.server.net.CommunicationState
import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.packet.PacketInformation

@PacketInformation (
        packetID = 0x1E,
        state = CommunicationState.PLAY,
        components = ["itemName"]
)

class NameItem : Packet {
    val itemName: String = ""
}