package dev.acaica.server.communication.packet.out.login

import dev.acaica.server.JSONChat
import dev.acaica.server.communication.CommunicationState
import dev.acaica.server.communication.packet.Packet
import dev.acaica.server.communication.packet.PacketInformation

@PacketInformation(
        packetID = 0x00,
        state = CommunicationState.LOGIN
)
class Disconnect(reason: String) : Packet() {
    constructor(chat: JSONChat) : this(chat.toString())
}