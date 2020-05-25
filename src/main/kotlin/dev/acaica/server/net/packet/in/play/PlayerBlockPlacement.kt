package dev.acaica.server.net.packet.`in`.play

import dev.acaica.server.net.CommunicationState
import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.packet.PacketInformation
import dev.acaica.server.net.types.PacketPosition
import dev.acaica.server.net.types.VarInt

@PacketInformation (
        packetID = 0x2C,
        state = CommunicationState.PLAY,
        components = ["hand", "location", "face", "cursorPositionX", "cursorPositionY", "cursorPositionZ", "insideBlock"]
)

class PlayerBlockPlacement : Packet {
    val hand: VarInt = VarInt(byteArrayOf())
    val location: PacketPosition = PacketPosition(0)
    val face: VarInt = VarInt(byteArrayOf())
    val cursorPositionX: Float = 0f
    val cursorPositionY: Float = 0f
    val cursorPositionZ: Float = 0f
    val insideBlock: Boolean = false
}