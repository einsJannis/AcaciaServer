package dev.acaica.server.net.packet.out.play

import dev.acaica.server.net.CommunicationState
import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.packet.PacketInformation

@PacketInformation(
        packetID = 0x13,
        state = CommunicationState.PLAY,
        components = ["windowID", "actionNumber", "accepted"]
)
class WindowConfirmation(val windowID: Byte, val actionNumber: Short, val accepted: Boolean) : Packet