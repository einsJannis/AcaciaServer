package dev.acaica.server.communication.packet.out.login

import dev.acaica.server.communication.CommunicationState
import dev.acaica.server.communication.packet.Packet
import dev.acaica.server.communication.packet.PacketInformation
import dev.acaica.server.communication.types.VarInt

@PacketInformation(
        packetID = 0x03,
        state = CommunicationState.LOGIN
)
class SetCompression(val threshold: VarInt) : Packet()