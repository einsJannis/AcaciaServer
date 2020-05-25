package dev.acaica.server.net.packet.out.play

import dev.acaica.server.net.CommunicationState
import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.packet.PacketInformation
import dev.acaica.server.types.Position

@PacketInformation(
        packetID = 0x30,
        state = CommunicationState.PLAY,
        components = ["location"]
)
class OpenSignEditor(val location: Position) : Packet