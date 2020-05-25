package dev.acaica.server.net.packet.out.play

import dev.acaica.server.net.CommunicationState
import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.packet.PacketInformation

@PacketInformation(
        packetID = 0x21,
        state = CommunicationState.PLAY,
        components = ["keepAliveID"]
)
class KeepAlive(val keepAliveID: Long) : Packet