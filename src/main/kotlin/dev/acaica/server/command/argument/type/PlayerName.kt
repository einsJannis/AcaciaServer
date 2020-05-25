package dev.acaica.server.command.argument.type

import dev.acaica.server.AcaciaServer
import dev.acaica.server.entity.Player

class PlayerName(val username: String) : CommandArgumentType {
    fun isValid(): Boolean {
        return toPlayer() != null
    }
    fun toPlayer(): Player? {
        return AcaciaServer.onlinePlayers.find { it.username == username }
    }
    override fun toString(): String {
        return username
    }
    companion object : CommandArgumentTypeCompanion<PlayerName> {
        override fun fromString(string: String): PlayerName = PlayerName(string)
    }
}