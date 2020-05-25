package dev.acaica.server.net.packet.out.play

import dev.acaica.server.net.CommunicationState
import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.packet.PacketInformation
import dev.acaica.server.net.types.SlotData

@PacketInformation(
        packetID = 0x17,
        state = CommunicationState.PLAY,
        components = ["windowID", "slot", "slotData"]
)
class SetSlot(val windowID: Byte, val slot: Short, val slotData: SlotData) : Packet