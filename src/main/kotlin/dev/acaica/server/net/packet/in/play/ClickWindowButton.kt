package dev.acaica.server.net.packet.`in`.play

import dev.acaica.server.net.CommunicationState
import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.packet.PacketInformation

@PacketInformation (
    packetID = 0x08,
    state = CommunicationState.PLAY,
    components = ["windowID", "buttonID"]
)

class ClickWindowButton : Packet {
    val windowID: Byte = 0x0
    val buttonID: Byte = 0x0
}