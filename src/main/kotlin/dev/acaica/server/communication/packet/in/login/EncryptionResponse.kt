package dev.acaica.server.communication.packet.`in`.login

import dev.acaica.server.communication.packet.Packet
import dev.acaica.server.communication.types.VarInt
import java.io.ByteArrayInputStream

class EncryptionResponse(val sharedSecretLength: VarInt, val sharedSecret: ByteArray, val verifyTokenLength: VarInt, val verifyToken: ByteArray) : Packet() {
    companion object {
        fun build(data: ByteArray): EncryptionResponse {
            val inputStream = ByteArrayInputStream(data)
            val sharedSecretLength = VarInt.readFromInputStream(inputStream)
            val sharedSecret = inputStream.readNBytes(sharedSecretLength.toInt())
            val verifyTokenLength = VarInt.readFromInputStream(inputStream)
            val verifyToken = inputStream.readNBytes(verifyTokenLength.toInt())
            return EncryptionResponse(sharedSecretLength, sharedSecret, verifyTokenLength, verifyToken)
        }
    }
}