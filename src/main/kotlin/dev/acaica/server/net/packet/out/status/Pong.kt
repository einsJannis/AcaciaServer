package dev.acaica.server.net.packet.out.status

import dev.acaica.server.net.CommunicationState
import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.packet.PacketInformation
import dev.acaica.server.net.packet.`in`.status.Ping

@PacketInformation(
        packetID = 0x01,
        state = CommunicationState.STATUS,
        components = ["payload"]
)
class Pong(val payload: Long) : Packet {
    constructor(pingPacket: Ping) : this(pingPacket.payload)
}