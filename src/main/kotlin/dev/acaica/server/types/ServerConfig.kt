package dev.acaica.server.types

import dev.acaica.server.JSONChat

class ServerConfig(
        var port: Int,
        var maxPlayers: Int,
        var motd: JSONChat,
        var serverVersion: String,
        var protocolVersion: Int
) {
    companion object {
        fun default() = ServerConfig(
                port = 25565,
                maxPlayers = 20,
                motd = JSONChat("This is an Acacia Server"),
                serverVersion = "Acacia Server 1.15.2",
                protocolVersion = 578
        )
    }
}
