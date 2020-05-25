package dev.acaica.server.net.packet

interface PacketInCompanion {
    fun build(data: ByteArray) : Packet
}