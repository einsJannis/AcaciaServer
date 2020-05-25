package dev.acaica.server.net.types

//import dev.einsjannis.kms.Position
import java.nio.ByteBuffer

class PacketPosition(private val data: Long) {
    fun toByteArray(): ByteArray {
        val buffer = ByteBuffer.allocate(8)
        buffer.putLong(data)
        return buffer.array()
    }
    /*fun toPosition(): Position {
        val x = (data shr 38).toDouble()
        val y = (data and 0xFFF).toDouble()
        val z = (data shl 26 shr 38).toDouble()
        return Position(x, y, z)
    }
    companion object {
        fun fromPosition(position: Position): PacketPosition {
            return PacketPosition(position.x.toLong() and 0x3FFFFFF shl 38 or (position.z.toLong() and 0x3FFFFFF shl 12) or (position.y.toLong() and 0xFFF))
        }
    }*/
}
