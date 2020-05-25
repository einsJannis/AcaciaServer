package dev.acaica.server.net.packet.`in`.play

import dev.acaica.server.net.CommunicationState
import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.packet.PacketInformation
import dev.acaica.server.net.types.SlotData

@PacketInformation (
        packetID = 0x26,
        state = CommunicationState.PLAY,
        components = ["slot", "clickedItem"]
)

class CreativeInventoryAction : Packet {
    val slot: Short = 0
    val clickedItem: SlotData = SlotData()
}