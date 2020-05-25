package dev.acaica.server.net.packet.out.play

import dev.acaica.server.net.CommunicationState
import dev.acaica.server.net.packet.PacketInformation

@PacketInformation(
        packetID = 0x1C,
        state = CommunicationState.PLAY,
        components = ["entityID", "entityStatus"]
)
class EntityStatus(val entityID: Int, val entityStatus: Byte)