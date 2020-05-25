package dev.acaica.server.net.packet.`in`.status

import dev.acaica.server.net.CommunicationState
import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.packet.PacketInCompanion
import dev.acaica.server.net.packet.PacketInformation
import java.io.ByteArrayInputStream
import java.io.DataInputStream

@PacketInformation(
        packetID = 0x01,
        state = CommunicationState.STATUS,
        components = ["payload"]
)
class Ping : Packet {
    var payload: Long = 0
}