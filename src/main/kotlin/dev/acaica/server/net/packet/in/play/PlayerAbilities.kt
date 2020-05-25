package dev.acaica.server.net.packet.`in`.play

import dev.acaica.server.net.CommunicationState
import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.packet.PacketInformation

@PacketInformation (
        packetID = 0x19,
        state = CommunicationState.PLAY,
        components = ["flags", "flyingSpeed", "walkingSpeed"]
)

class PlayerAbilities : Packet {
    val flags: Byte = 0x0
    val flyingSpeed: Float = 0f
    val walkingSpeed: Float = 0f
}