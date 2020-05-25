package dev.acaica.server.entity

import dev.acaica.server.JSONChat
import dev.acaica.server.types.Position
import dev.acaica.server.types.Rotation
import dev.acaica.server.net.Client
import java.util.*

class Player(
        override val uniqueId: UUID,
        val username: String,
        val client: Client,
        override var skin: ByteArray,
        override var health: Int,
        override var position: Position,
        override var rotation: Rotation
): CommandSender, HumanEntity {
    init { players.add(this) }
    companion object { val players: MutableCollection<Player> = mutableListOf() }

    override fun sendMessage(message: JSONChat) {
        TODO("Not yet implemented")
    }

    override fun sendWarning(message: JSONChat) {
        TODO("Not yet implemented")
    }

    override fun sendError(message: JSONChat) {
        TODO("Not yet implemented")
    }
}
