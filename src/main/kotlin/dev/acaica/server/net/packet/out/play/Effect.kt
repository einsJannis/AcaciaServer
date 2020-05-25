package dev.acaica.server.net.packet.out.play

import dev.acaica.server.net.CommunicationState
import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.packet.PacketInformation
import dev.acaica.server.net.types.PacketPosition

@PacketInformation(
        packetID = 0x23,
        state = CommunicationState.PLAY,
        components = ["effectID", "location", "data", "disableRelativeVolume"]
)
class Effect(val effectID: Int, val location: PacketPosition, val data: Int, val disableRelativeVolume: Boolean) : Packet