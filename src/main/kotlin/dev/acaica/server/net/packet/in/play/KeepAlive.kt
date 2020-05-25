package dev.acaica.server.net.packet.`in`.play

import dev.acaica.server.net.CommunicationState
import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.packet.PacketInformation

@PacketInformation (
        packetID = 0x0F,
        state = CommunicationState.PLAY,
        components = ["keepAliveID"]
)

class KeepAlive : Packet {
    val keepAliveID: Long = 1
}