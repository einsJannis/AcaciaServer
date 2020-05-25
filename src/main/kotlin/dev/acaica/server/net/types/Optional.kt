package dev.acaica.server.net.types

import dev.acaica.server.net.packet.Packet
import io.netty.buffer.ByteBuf

class Optional<T>(val value: T?) {
    companion object {
        fun <T> handle(byteBuf: ByteBuf, packet: Packet, propertyName: String): Optional<T> {
            TODO()
        }
    }
}