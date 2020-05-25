package dev.acaica.server.net.packet.`in`.play

import dev.acaica.server.net.CommunicationState
import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.packet.PacketInformation
import dev.acaica.server.net.types.PacketPosition
import dev.acaica.server.net.types.VarInt

@PacketInformation (
        packetID = 0x01,
        state = CommunicationState.PLAY,
        components = ["transactionID", "location"]
)

class QueryBlockNBT : Packet {
    val transactionID: VarInt = VarInt(byteArrayOf())
    val location: PacketPosition = PacketPosition(69)
}