package dev.acaica.server.net.packet.out.play

import dev.acaica.server.net.CommunicationState
import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.packet.PacketInformation

@PacketInformation(
        packetID = 0x16,
        state = CommunicationState.PLAY,
        components = ["windowID", "property", "value"]
)
class WindowProperty(val windowID: UByte, val property: Short, val value: Short) : Packet