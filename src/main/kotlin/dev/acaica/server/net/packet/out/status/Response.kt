package dev.acaica.server.net.packet.out.status

import com.google.gson.Gson
import dev.acaica.server.AcaciaServer
import dev.acaica.server.JSONChat
import dev.acaica.server.types.ServerConfig
import dev.acaica.server.net.CommunicationState
import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.packet.PacketInformation

@PacketInformation(
        packetID = 0x00,
        state = CommunicationState.STATUS,
        components = ["jsonResponse"]
)
class Response(val jsonResponse: String) : Packet {
    constructor(responseGSON: ResponseGSON) : this(Gson().toJson(responseGSON))
    companion object {
        fun fromServerConfig(serverConfig: ServerConfig) = Response(
                ResponseGSON(
                        serverConfig.serverVersion,
                        serverConfig.protocolVersion,
                        serverConfig.maxPlayers,
                        AcaciaServer.onlinePlayers.size,
                        serverConfig.motd
                )
        )
    }
    class ResponseGSON(versionName: String, protocolVersion: Int, maxPlayers: Int, onlinePlayers: Int, val description: JSONChat) {
        val version = mapOf<String, Any>("name" to versionName, "protocol" to protocolVersion)
        val players = mapOf<String, Any>("max" to maxPlayers, "online" to onlinePlayers, "sample" to listOf<Unit>())
    }
}