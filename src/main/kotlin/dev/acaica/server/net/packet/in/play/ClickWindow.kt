package dev.acaica.server.net.packet.`in`.play

import dev.acaica.server.net.CommunicationState
import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.packet.PacketInformation
import dev.acaica.server.net.types.SlotData
import dev.acaica.server.net.types.VarInt

@PacketInformation (
        packetID = 0x09,
        state = CommunicationState.PLAY,
        components = ["windowID", "slot", "button", "actionNumber", "mode", "clickedItem"]
)

class ClickWindow : Packet {
    val windowID = 0x00.toUByte()
    val slot: Short = 0
    val button: Byte = 0x00
    val actionNumber: Short = 1
    val mode: VarInt = VarInt(byteArrayOf())
    val clickedItem: SlotData = SlotData()
}