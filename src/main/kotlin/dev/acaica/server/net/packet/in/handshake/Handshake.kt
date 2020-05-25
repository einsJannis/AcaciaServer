package dev.acaica.server.net.packet.`in`.handshake

import dev.acaica.server.net.CommunicationState
import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.packet.PacketInCompanion
import dev.acaica.server.net.packet.PacketInformation
import dev.acaica.server.net.types.PacketStringUtil
import dev.acaica.server.net.types.VarInt
import java.io.ByteArrayInputStream
import java.io.DataInputStream

@PacketInformation(
        packetID = 0x00,
        state = CommunicationState.HANDSHAKING,
        components = ["protocolVersion", "serverAddress", "serverPort", "nextState"]
)
class Handshake : Packet {
    var protocolVersion: VarInt = VarInt(byteArrayOf())
    var serverAddress: String = ""
    @ExperimentalUnsignedTypes
    var serverPort: UShort = 0u
    var nextState: CommunicationState = CommunicationState.STATUS
}
