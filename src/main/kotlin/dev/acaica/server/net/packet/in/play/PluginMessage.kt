package dev.acaica.server.net.packet.`in`.play

import dev.acaica.server.net.CommunicationState
import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.packet.PacketInformation
import dev.acaica.server.types.Identifier

@PacketInformation (
        packetID = 0x0B,
        state = CommunicationState.PLAY,
        components = ["channel", "data"]
)

class PluginMessage : Packet {
    val channel: Identifier = Identifier("", "")
    val data: ByteArray = byteArrayOf()
}