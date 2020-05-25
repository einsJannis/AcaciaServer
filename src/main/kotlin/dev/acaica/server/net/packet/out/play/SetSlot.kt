package dev.acaica.server.net.packet.out.play

import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.types.SlotData

class SetSlot(val windowID: Byte, val slot: Short, val slotData: SlotData) : Packet