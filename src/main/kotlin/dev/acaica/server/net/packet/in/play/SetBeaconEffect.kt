package dev.acaica.server.net.packet.`in`.play

import dev.acaica.server.net.CommunicationState
import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.packet.PacketInformation
import dev.acaica.server.net.types.VarInt

@PacketInformation (
        packetID = 0x22,
        state = CommunicationState.PLAY,
        components = ["primaryEffect", "secondaryEffect"]
)

class SetBeaconEffect : Packet {
    val primaryEffect: VarInt = VarInt(byteArrayOf())
    val secondaryEffect: VarInt = VarInt(byteArrayOf())
}