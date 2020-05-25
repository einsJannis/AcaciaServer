package dev.acaica.server.net.types

class Angle(val byte: Byte) {
    fun toByteArray(): ByteArray {
        return byteArrayOf(byte)
    }
}