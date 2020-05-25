package dev.acaica.server.net.packet.`in`.play

import dev.acaica.server.net.CommunicationState
import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.packet.PacketInformation
import dev.acaica.server.net.types.VarInt

@PacketInformation (
        packetID = 0x0D,
        state = CommunicationState.PLAY,
        components = ["transactionID", "entityID"]
)

class EditNBTRequest : Packet {
    val transactionID: VarInt = VarInt(byteArrayOf())
    val entityID: VarInt = VarInt(byteArrayOf())
}