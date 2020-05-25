package dev.acaica.server.net.packet.out.play

import dev.acaica.server.net.CommunicationState
import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.packet.PacketInformation
import dev.acaica.server.net.types.VarInt

@PacketInformation(
        packetID = 0x06,
        state = CommunicationState.PLAY,
        components = ["entityID", "animation"]
)
class EntityAnimation(val entityID: VarInt, val animation: UByte) : Packet