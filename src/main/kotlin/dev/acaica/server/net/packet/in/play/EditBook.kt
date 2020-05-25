package dev.acaica.server.net.packet.`in`.play

import dev.acaica.server.net.CommunicationState
import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.packet.PacketInformation
import dev.acaica.server.net.types.SlotData
import dev.acaica.server.net.types.VarInt

@PacketInformation (
        packetID = 0x0C,
        state = CommunicationState.PLAY,
        components = ["newBook", "isSigning", "hand"]
)

class EditBook : Packet {
    val newBook: SlotData = SlotData()
    val isSigning: Boolean = false
    val hand: VarInt = VarInt(byteArrayOf())
}