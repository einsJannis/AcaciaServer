package dev.acaica.server.net.packet.`in`.play

import dev.acaica.server.net.CommunicationState
import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.packet.PacketInformation

@PacketInformation (
        packetID = 0x02,
        state = CommunicationState.PLAY,
        components = ["newDifficulty"]
)

class SetDifficulty : Packet {
    val newDifficulty: Byte = 0x03
}