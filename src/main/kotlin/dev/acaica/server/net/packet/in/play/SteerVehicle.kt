package dev.acaica.server.net.packet.`in`.play

import dev.acaica.server.net.CommunicationState
import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.packet.PacketInformation

@PacketInformation(
        packetID = 0x1C,
        state = CommunicationState.PLAY,
        components = ["sideWays", "forward", "flags"]
)

class SteerVehicle : Packet {
    val sideWays: Float = 0f
    val forward: Float = 0f
    var flags = 0x00.toUByte()
}