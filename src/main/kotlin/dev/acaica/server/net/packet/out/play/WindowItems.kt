package dev.acaica.server.net.packet.out.play

import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.types.SlotData

class WindowItems(val windowID: UByte, val count: Short, val slotData: Array<SlotData>) : Packet