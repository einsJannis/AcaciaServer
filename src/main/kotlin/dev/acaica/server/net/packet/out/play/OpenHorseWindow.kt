package dev.acaica.server.net.packet.out.play

import dev.acaica.server.net.CommunicationState
import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.packet.PacketInformation
import dev.acaica.server.net.types.VarInt

@PacketInformation(
        packetID = 0x20,
        state = CommunicationState.PLAY,
        components = ["windowID", "numberOfSlots", "entityID"]
)
class OpenHorseWindow(val windowID: Byte, val numberOfSlots: VarInt, val entityID: Integer) : Packet