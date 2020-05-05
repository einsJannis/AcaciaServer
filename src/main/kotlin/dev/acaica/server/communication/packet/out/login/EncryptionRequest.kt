package dev.acaica.server.communication.packet.out.login

import dev.acaica.server.communication.CommunicationState
import dev.acaica.server.communication.packet.Packet
import dev.acaica.server.communication.packet.PacketInformation
import dev.acaica.server.communication.types.VarInt

@PacketInformation(
        packetID = 0x01,
        state = CommunicationState.LOGIN
)
class EncryptionRequest(
        val serverID: String,
        val publicKeyLength: VarInt,
        val publicKey: ByteArray,
        val verifyTokenLength: VarInt,
        val verifyToken: ByteArray
) : Packet() {
    constructor(
            serverID: String,
            publicKey: ByteArray,
            verifyToken: ByteArray
    ) : this(
            serverID,
            VarInt.fromInt(publicKey.size),
            publicKey,
            VarInt.fromInt(verifyToken.size),
            verifyToken
    )
}