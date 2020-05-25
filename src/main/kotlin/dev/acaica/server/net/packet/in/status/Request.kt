package dev.acaica.server.net.packet.`in`.status

import dev.acaica.server.net.CommunicationState
import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.packet.PacketInCompanion
import dev.acaica.server.net.packet.PacketInformation

@PacketInformation(
        packetID = 0x00,
        state = CommunicationState.STATUS,
        components = []
)
class Request : Packet {
    companion object : PacketInCompanion {
        override fun build(data: ByteArray): Request {
            return Request()
        }
    }
}