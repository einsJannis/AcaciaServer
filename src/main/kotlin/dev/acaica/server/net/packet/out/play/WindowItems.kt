package dev.acaica.server.net.packet.out.play

import dev.acaica.server.net.CommunicationState
import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.packet.PacketInformation
import dev.acaica.server.net.types.SlotData

@PacketInformation(
        packetID = 0x15,
        state = CommunicationState.PLAY,
        components = ["windowID", "count", "slotData"]
)
class WindowItems(val windowID: UByte, val count: Short, val slotData: Array<SlotData>) : Packet