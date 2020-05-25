package dev.acaica.server.net.packet.out.play

import dev.acaica.server.net.CommunicationState
import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.packet.PacketInformation
import dev.acaica.server.types.Identifier

@PacketInformation(
        packetID = 0x19,
        state = CommunicationState.PLAY,
        components = ["channel", "data"]
)
class PluginMessage(val channel: Identifier, val data: ByteArray) : Packet