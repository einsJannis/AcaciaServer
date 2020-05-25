package dev.acaica.server.net.packet.`in`.play

import dev.acaica.server.net.CommunicationState
import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.packet.PacketInformation

@PacketInformation (
        packetID = 0x07,
        state = CommunicationState.PLAY,
        components = ["windowID", "actionNumber", "accepted"]
)

class WindowConfirmation : Packet {
    val windowID: Byte = 0x01
    val actionNumber: Short = 1
    val accepted: Boolean = false
}