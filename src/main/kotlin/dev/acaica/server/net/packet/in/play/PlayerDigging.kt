package dev.acaica.server.net.packet.`in`.play

import dev.acaica.server.net.CommunicationState
import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.packet.PacketInformation
import dev.acaica.server.net.types.PacketPosition
import dev.acaica.server.net.types.VarInt

@PacketInformation (
        packetID = 0x1A,
        state = CommunicationState.PLAY,
        components = ["status", "location", "face"]
)

class PlayerDigging : Packet {
    val status: VarInt = VarInt(byteArrayOf())
    val location: PacketPosition = PacketPosition(0)
    val face: Byte = 0x0
}