package dev.acaica.server.net.packet.`in`.play

import dev.acaica.server.net.CommunicationState
import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.packet.PacketInformation
import dev.acaica.server.net.types.VarInt

@PacketInformation (
        packetID = 0x25,
        state = CommunicationState.PLAY,
        components = ["entityID", "command", "trackOutput"]
)

class UpdateCommandBlockMinecart : Packet {
    val entityID: VarInt = VarInt(byteArrayOf())
    val command: String = ""
    val trackOutput: Boolean = false
}