package dev.acaica.server.net.types

import io.netty.buffer.ByteBuf
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.InputStream

data class VarInt(private val byteArray: ByteArray) {

    init {
        if (byteArray.size > 5) throw RuntimeException("VarInt is too big")
    }

    fun toByteArray(): ByteArray {
        return byteArray
    }

    fun toInt(): Int {
        val byteArrayInputStream = ByteArrayInputStream(byteArray)
        var numRead = 0
        var result: Int = 0
        var read: Int
        do {
            read = byteArrayInputStream.read()
            val value: Int = read and 127
            result = result or (value shl 7 * numRead)
            numRead++
            if (numRead > 5) {
                throw RuntimeException("VarInt is too big")
            }
        } while (read and 128 != 0)
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
            val byteArrayOutputStream = ByteArrayOutputStream()
            var value = int
            do {
                var temp = (value and 127)
                value = value ushr 7
                if (value != 0) {
                    temp = temp or 128
                }
                byteArrayOutputStream.write(temp)
            } while (value != 0)
            val i = VarInt(byteArrayOutputStream.toByteArray())
            return i
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