package dev.acaica.server.communication.packet.`in`.handshake

import dev.acaica.server.communication.CommunicationState
import dev.acaica.server.communication.packet.Packet
import dev.acaica.server.communication.packet.PacketInformation
import dev.acaica.server.communication.types.PacketStringUtil
import dev.acaica.server.communication.types.VarInt
import java.io.ByteArrayInputStream
import java.io.DataInputStream

@PacketInformation(
        packetID = 0x00,
        state = CommunicationState.HANDSHAKING
)
class Handshake(val protocolVersion: VarInt, val serverAddress: String, val serverPort: UShort, val nextState: CommunicationState) : Packet() {
    companion object {
        @ExperimentalUnsignedTypes
        fun build(data: ByteArray): Handshake {
            println("building")
            val byteStream = ByteArrayInputStream(data)
            val protocolVersion = VarInt.readFromInputStream(byteStream)
            val serverAddress = PacketStringUtil.readFromInputStream(byteStream)
            val serverPort = DataInputStream(byteStream).readUnsignedShort().toUShort()
            val nextState = CommunicationState.values()[VarInt.readFromInputStream(byteStream).toInt()]
            return Handshake(protocolVersion, serverAddress, serverPort, nextState)
        }
    }
}
