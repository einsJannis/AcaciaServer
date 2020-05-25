package dev.acaica.server.net.packet.`in`.play

import dev.acaica.server.net.CommunicationState
import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.packet.PacketInformation
import dev.acaica.server.net.types.VarInt

@PacketInformation (
        packetID = 0x0E,
        state = CommunicationState.PLAY,
        components = ["entityID", "type", "targetX", "targetY", "targetZ", "hand"]
)

class InteractEntity : Packet {
    val entityID: VarInt = VarInt(byteArrayOf())
    val type: VarInt = VarInt(byteArrayOf())
    val targetX: Float? = null
    val targetY: Float? = null
    val targetZ: Float? = null
    val hand: VarInt = VarInt(byteArrayOf())
}