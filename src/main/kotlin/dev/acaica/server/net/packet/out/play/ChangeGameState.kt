package dev.acaica.server.net.packet.out.play

import dev.acaica.server.net.CommunicationState
import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.packet.PacketInformation

@PacketInformation(
        packetID = 0x1F,
        state = CommunicationState.PLAY,
        components = ["reason", "value"]
)
class ChangeGameState(val reason: UByte, val value: Float) : Packet