package dev.acaica.server.communication.packet.out.status

import dev.acaica.server.communication.CommunicationState
import dev.acaica.server.communication.packet.Packet
import dev.acaica.server.communication.packet.PacketInformation
import dev.einsjannis.kms.commmunication.packet.server.status.Ping

@PacketInformation(
        packetID = 0x01,
        state = CommunicationState.STATUS
)
class Pong(val long: Long) : Packet() {
    constructor(pingPacket: Ping) : this(pingPacket.long)
}