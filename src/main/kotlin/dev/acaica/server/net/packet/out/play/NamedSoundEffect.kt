package dev.acaica.server.net.packet.out.play

import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.types.VarInt
import dev.acaica.server.types.Identifier

class NamedSoundEffect(
        val soundName: Identifier,
        val soundCategory: VarInt,
        val effectPositionX: Int,
        val effectPositionY: Int,
        val effectPositionZ: Int,
        val volume: Float,
        val pitch: Float
) : Packet