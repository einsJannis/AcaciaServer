package dev.acaica.server.net.packet.out.play

import dev.acaica.server.net.CommunicationState
import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.packet.PacketInformation
import dev.acaica.server.net.types.VarInt

@PacketInformation(
        packetID = 0x2C,
        state = CommunicationState.PLAY,
        components = ["entityID"]
)
class EntityMovement(val entityID: VarInt) : Packet