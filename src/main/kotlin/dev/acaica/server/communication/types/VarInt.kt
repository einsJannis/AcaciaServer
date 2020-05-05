package dev.acaica.server.communication.types

import io.netty.buffer.ByteBuf
import java.io.InputStream
import java.io.OutputStream
import kotlin.reflect.KClass

data class VarInt(private val byteArray: ByteArray) {

    init {
        if (byteArray.size > 5) throw RuntimeException("VarInt is too big")
    }

    fun toByteArray(): ByteArray {
        return byteArray
    }

    fun toInt(): Int {
        var result = 0
        for (i in byteArray.indices) {
            val value = byteArray[i].toInt()
            result = result or (value shl 7 * i)
        }
        return result
    }

    override fun equals(other: Any?): Boolean {
        return when (other) {
            is VarInt -> other.toInt() == toInt()
            is Int -> other == toInt()
            is ByteArray -> other == toByteArray()
            else -> false
        }
    }

    companion object {
        fun fromInt(int: Int): VarInt {
            var value = int
            var result = ByteArray(0)
            do {
                var temp = (value and 127)
                value = value ushr 7
                if (value != 0) {
                    temp = temp or 128
                }
                result = byteArrayOf(*result, temp.toByte())
            } while (value != 0)
            return VarInt(result)
        }
        fun readFromByteBuffer(byteBuf: ByteBuf): VarInt {
            return readFromByteReader(getByteReader(byteBuf))
        }
        fun readFromInputStream(inputStream: InputStream): VarInt {
            return readFromByteReader(getByteReader(inputStream))
        }
        fun readFromByteReader(byteReader: () -> Int): VarInt {
            var result = ByteArray(0)
            var read: Int
            do {
                read = byteReader()
                result = byteArrayOf(*result, read.toByte())
            } while (read and 128 != 0)
            return VarInt(result)
        }
    }
}