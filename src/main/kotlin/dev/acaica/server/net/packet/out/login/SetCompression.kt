package dev.acaica.server.net.packet.out.login

import dev.acaica.server.net.CommunicationState
import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.packet.PacketInformation
import dev.acaica.server.net.types.VarInt

@PacketInformation(
        packetID = 0x03,
        state = CommunicationState.LOGIN,
        components = ["threshold"]
)
class SetCompression(val threshold: VarInt) : Packet