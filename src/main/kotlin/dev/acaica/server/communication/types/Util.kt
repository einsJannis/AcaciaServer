package dev.acaica.server.communication.types

import io.netty.buffer.ByteBuf
import java.io.DataInputStream
import java.io.InputStream

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