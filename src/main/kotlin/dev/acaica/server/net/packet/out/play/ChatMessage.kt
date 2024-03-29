package dev.acaica.server.net.packet.out.play

import dev.acaica.server.JSONChat
import dev.acaica.server.net.CommunicationState
import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.packet.PacketInformation

@PacketInformation(
        packetID = 0x0F,
        state = CommunicationState.PLAY,
        components = ["jsonData", "postion"]
)
class ChatMessage(jsonData: String, position: Byte) : Packet {
    constructor(jsonData: JSONChat, position: Byte) : this(jsonData.toString(), position)
}
