package dev.acaica.server.communication.packet.out.login

import dev.acaica.server.communication.CommunicationState
import dev.acaica.server.communication.packet.Packet
import dev.acaica.server.communication.packet.PacketInformation

@PacketInformation(
        packetID = 0x02,
        state = CommunicationState.LOGIN
)
class LoginSuccess(val uuid: String, val username: String) : Packet()