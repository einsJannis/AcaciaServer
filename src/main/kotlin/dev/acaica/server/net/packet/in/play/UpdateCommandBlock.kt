package dev.acaica.server.net.packet.`in`.play

import dev.acaica.server.net.CommunicationState
import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.packet.PacketInformation
import dev.acaica.server.net.types.PacketPosition
import dev.acaica.server.net.types.VarInt

@PacketInformation (
        packetID = 0x24,
        state = CommunicationState.PLAY,
        components = ["location", "command", "mode", "flags"]
)

class UpdateCommandBlock : Packet {
    val location: PacketPosition = PacketPosition(0)
    val command: String = ""
    val mode: VarInt = VarInt(byteArrayOf())
    val flags: Byte = 0x00
}