package dev.acaica.server.communication.packet.`in`.status

import dev.acaica.server.communication.CommunicationState
import dev.acaica.server.communication.packet.Packet
import dev.acaica.server.communication.packet.PacketInformation

@PacketInformation(
        packetID = 0x00,
        state = CommunicationState.STATUS
)
class Request : Packet() {
    companion object {
        fun build(data: ByteArray): Request {
            return Request()
        }
    }
}