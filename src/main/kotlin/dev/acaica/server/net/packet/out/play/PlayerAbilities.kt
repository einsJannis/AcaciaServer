package dev.acaica.server.net.packet.out.play

import dev.acaica.server.net.CommunicationState
import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.packet.PacketInformation

@PacketInformation(
        packetID = 0x32,
        state = CommunicationState.PLAY,
        components = ["flags", "float", "fieldOfViewModifier"]
)
class PlayerAbilities(val flags: Byte, val float: Float, val fieldOfViewModifier: Float) : Packet