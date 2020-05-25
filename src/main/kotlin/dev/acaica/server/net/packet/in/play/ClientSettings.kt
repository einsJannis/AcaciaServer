package dev.acaica.server.net.packet.`in`.play

import dev.acaica.server.net.CommunicationState
import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.packet.PacketInformation
import dev.acaica.server.net.types.VarInt

@PacketInformation (
        packetID = 0x05,
        state = CommunicationState.PLAY,
        components = ["locale", "viewDistance", "chatMode", "chatColors", "displayedSkinParts", "mainHand"]
)

class ClientSettings : Packet {
    val locale: String = ""
    val viewDistance: Byte = 0x01
    val chatMode: VarInt = VarInt(byteArrayOf())
    val chatColors: Boolean = false
    val displayedSkinParts = 0x00.toUByte()
    val mainHand: VarInt = VarInt(byteArrayOf())
}