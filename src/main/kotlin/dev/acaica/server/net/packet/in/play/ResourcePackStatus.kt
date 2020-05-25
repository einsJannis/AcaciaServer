package dev.acaica.server.net.packet.`in`.play

import dev.acaica.server.net.CommunicationState
import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.packet.PacketInformation
import dev.acaica.server.net.types.VarInt

@PacketInformation (
        packetID = 0x1F,
        state = CommunicationState.PLAY,
        components = ["result"]
)

class ResourcePackStatus : Packet {
    val result: VarInt = VarInt(byteArrayOf())
}