package dev.acaica.server.net.packet.out.play

import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.types.VarInt
import java.util.*

class BossBar(
        val uuid: UUID,
        val action: VarInt,
        val title: String?,
        val health: Float?,
        val color: VarInt?,
        val division: VarInt?,
        val flags: UByte?
) : Packet {
    init {
        when (action.toInt()) {
            0 -> {
                if (!(title != null && health != null && color != null && division != null && flags != null))
                    throw RuntimeException("Action add requires every field")
            }
            1 -> {
                if (!(title == null && health == null && color == null && division == null && flags == null))
                    throw RuntimeException("Action remove does not require any field")
            }
            2 -> {
                if (!(title == null && health != null && color == null && division == null && flags == null))
                    throw RuntimeException("Action update health requires the health field")
            }
            3 -> {
                if (!(title != null && health == null && color == null && division == null && flags == null))
                    throw RuntimeException("Action update title requires the title field")
            }
            4 -> {
                if (!(title == null && health == null && color != null && division != null && flags == null))
                    throw RuntimeException("Action update style requires the color and the division field")
            }
            5 -> {
                if (!(title == null && health == null && color == null && division == null && flags != null))
                    throw RuntimeException("Action update flags requires the color field")
            }
        }
    }
}