package dev.acaica.server.net.packet.out.login

import dev.acaica.server.net.CommunicationState
import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.packet.PacketInformation

@PacketInformation(
        packetID = 0x02,
        state = CommunicationState.LOGIN,
        components = ["uuid", "username"]
)
class LoginSuccess(val uuid: String, val username: String) : Packet