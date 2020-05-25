package dev.acaica.server.net.types

import io.netty.buffer.ByteBuf
import java.io.InputStream
import java.nio.ByteBuffer
import java.util.*

object PacketStringUtil {
    fun readFromByteBuffer(byteBuf: ByteBuf): String {
        return readFromByteReader(getByteReader(byteBuf))
    }
    fun readFromInputStream(inputStream: InputStream): String {
        return readFromByteReader(getByteReader(inputStream))
    }
    private fun readFromByteReader(byteReader: () -> Int): String {
        val length = VarInt.readFromByteReader(byteReader).toInt()
        val byteArray = ByteArray(length)
        for (i in 0 until length)
            byteArray[i] = byteReader().toByte()
        return byteArray.toString(Charsets.UTF_8)
    }
}


fun getByteReader(any: Any): () -> Int {
    when (any) {
        is InputStream -> {
            return {
                any.read()
            }
        }
        is ByteBuf -> {
            return {
                any.readByte().toInt()
            }
        }
        else -> throw NoSuchMethodException()
    }
}

fun UUID.toByteArray(): ByteArray {
    val byteBuffer = ByteBuffer.wrap(ByteArray(16))
    byteBuffer.putLong(this.mostSignificantBits)
    byteBuffer.putLong(this.leastSignificantBits)
    return byteBuffer.array()
}
