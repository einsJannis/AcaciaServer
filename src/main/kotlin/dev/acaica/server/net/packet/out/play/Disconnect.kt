package dev.acaica.server.net.packet.out.play

import dev.acaica.server.JSONChat
import dev.acaica.server.net.CommunicationState
import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.packet.PacketInformation

@PacketInformation(
        packetID = 0x1B,
        state = CommunicationState.PLAY,
        components = ["reason"]
)
class Disconnect(val reason: JSONChat) : Packet