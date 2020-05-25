package dev.acaica.server.net.types

import io.netty.buffer.ByteBuf

class EntityMetadata {

    fun toByteArray(): ByteArray {
        TODO("Not yet implemented")
    }

    companion object {
        fun readFromByteBuffer(byteBuf: ByteBuf): EntityMetadata {
            TODO()
        }
    }

}