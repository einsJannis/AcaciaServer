package dev.acaica.server.net.packet.`in`.play

import dev.acaica.server.net.CommunicationState
import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.packet.PacketInformation

@PacketInformation (
        packetID = 0x10,
        state = CommunicationState.PLAY,
        components = ["locked"]
)

class LockDifficulty : Packet {
    val locked: Boolean = false
}