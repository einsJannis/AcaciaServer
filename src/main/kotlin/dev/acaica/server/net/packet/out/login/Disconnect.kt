package dev.acaica.server.net.packet.out.login

import com.google.gson.Gson
import dev.acaica.server.JSONChat
import dev.acaica.server.net.CommunicationState
import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.packet.PacketInformation

@PacketInformation(
        packetID = 0x00,
        state = CommunicationState.LOGIN,
        components = ["reason"]
)
class Disconnect(reason: String) : Packet {
    constructor(chat: JSONChat) : this(Gson().toJson(chat))
}