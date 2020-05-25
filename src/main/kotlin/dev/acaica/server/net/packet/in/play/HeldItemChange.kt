package dev.acaica.server.net.packet.`in`.play

import dev.acaica.server.net.CommunicationState
import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.packet.PacketInformation

@PacketInformation (
        packetID = 0x23,
        state = CommunicationState.PLAY,
        components = ["slot"]
)

class HeldItemChange : Packet {
    val slot: Short = 0
}