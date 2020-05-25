package dev.acaica.server.net.packet.`in`.play

import dev.acaica.server.net.CommunicationState
import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.packet.PacketInformation
import dev.acaica.server.net.types.VarInt

@PacketInformation (
        packetID = 0x1B,
        state = CommunicationState.PLAY,
        components = ["entityID", "actionID", "jumpBoost"]
)

class EntityAction : Packet {
    val entityID: VarInt = VarInt(byteArrayOf())
    val actionID: VarInt = VarInt(byteArrayOf())
    val jumpBoost: VarInt = VarInt(byteArrayOf())
}