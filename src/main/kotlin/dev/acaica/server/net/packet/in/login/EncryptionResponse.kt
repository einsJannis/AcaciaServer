package dev.acaica.server.net.packet.`in`.login

import dev.acaica.server.net.CommunicationState
import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.packet.PacketInCompanion
import dev.acaica.server.net.packet.PacketInformation
import dev.acaica.server.net.types.VarInt
import java.io.ByteArrayInputStream

@PacketInformation(
        packetID = 0x01,
        state = CommunicationState.LOGIN,
        components = ["sharedSecret", "verifyToken"]
)
class EncryptionResponse : Packet {
    var sharedSecret: ByteArray = byteArrayOf()
    var verifyToken: ByteArray = byteArrayOf()
}