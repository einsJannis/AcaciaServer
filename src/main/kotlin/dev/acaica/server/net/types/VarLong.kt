package dev.acaica.server.net.types

import io.netty.buffer.ByteBuf
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.InputStream

data class VarLong(private val byteArray: ByteArray) {

    init {
        if (byteArray.size > 5) throw RuntimeException("VarLong is too Long")
    }

    fun toByteArray(): ByteArray {
        return byteArray
    }

    fun toLong(): Long {
        val byteArrayInputStream = ByteArrayInputStream(byteArray)
        var numRead = 0
        var result: Long = 0
        var read: Int
        do {
            read = byteArrayInputStream.read()
            val value: Int = read and 127
            result = result or (value shl 7 * numRead).toLong()
            numRead++
            if (numRead > 10) {
                throw RuntimeException("VarLong is too big")
            }
        } while (read and 128 != 0)
        return result
    }

    override fun equals(other: Any?): Boolean {
        return when (other) {
            is VarLong -> other.toByteArray().contentEquals(toByteArray())
            is Long -> other == toLong()
            is ByteArray -> other == toByteArray()
            else -> false
        }
    }
    companion object {
        fun fromLong(long: Long): VarLong {
            val byteArrayOutputStream = ByteArrayOutputStream()
            var value = long
            do {
                var temp = (value and 127)
                value = value ushr 7
                if (value != 0L) {
                    temp = temp or 128
                }
                byteArrayOutputStream.write(temp.toInt())
            } while (value != 0L)
            return VarLong(byteArrayOutputStream.toByteArray())
        }
        fun readFromByteBuffer(byteBuf: ByteBuf): VarLong {
            return readFromByteReader(getByteReader(byteBuf))
        }
        fun readFromInputStream(inputStream: InputStream): VarLong {
            return readFromByteReader(getByteReader(inputStream))
        }
        fun readFromByteReader(byteReader: () -> Int): VarLong {
            var result = ByteArray(0)
            var read: Int
            do {
                read = byteReader()
                result = byteArrayOf(*result, (read and 127).toByte())
            } while (read and 128 != 0)
            return VarLong(result)
        }
    }
}
