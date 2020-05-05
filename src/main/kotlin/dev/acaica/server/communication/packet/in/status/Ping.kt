package dev.einsjannis.kms.commmunication.packet.server.status

import dev.acaica.server.communication.CommunicationState
import dev.acaica.server.communication.packet.Packet
import dev.acaica.server.communication.packet.PacketInformation
import java.io.ByteArrayInputStream
import java.io.DataInputStream

@PacketInformation(
        packetID = 0x01,
        state = CommunicationState.STATUS
)
class Ping(val long: Long) : Packet() {
    companion object {
        fun build(data: ByteArray): Ping {
            return Ping(DataInputStream(ByteArrayInputStream(data)).readLong())
        }
    }
}