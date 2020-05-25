package dev.acaica.server.net.packet.out.login

import dev.acaica.server.net.CommunicationState
import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.packet.PacketInformation
import dev.acaica.server.net.types.VarInt

@PacketInformation(
        packetID = 0x01,
        state = CommunicationState.LOGIN,
        components = ["serverID", "publicKeyLength", "publicKey", "verifyTokenLength", "verifyToken"]
)
class EncryptionRequest(
        val serverID: String,
        val publicKeyLength: VarInt,
        val publicKey: ByteArray,
        val verifyTokenLength: VarInt,
        val verifyToken: ByteArray
) : Packet {
    constructor(
            publicKey: ByteArray,
            verifyToken: ByteArray
    ) : this(
            "",
            VarInt.fromInt(publicKey.size),
            publicKey,
            VarInt.fromInt(verifyToken.size),
            verifyToken
    )
}