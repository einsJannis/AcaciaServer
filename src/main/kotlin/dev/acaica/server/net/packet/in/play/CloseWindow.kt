package dev.acaica.server.net.packet.`in`.play

import dev.acaica.server.net.CommunicationState
import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.packet.PacketInformation

@PacketInformation (
        packetID = 0x0A,
        state = CommunicationState.PLAY,
        components = ["windowID"]
)

class CloseWindow : Packet {
    val windowID = 0x0.toUByte()
}