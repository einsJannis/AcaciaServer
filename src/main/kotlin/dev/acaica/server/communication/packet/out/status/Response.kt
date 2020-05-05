package dev.acaica.server.communication.packet.out.status

import com.google.gson.Gson
import dev.acaica.server.JSONChat
import dev.acaica.server.communication.CommunicationState
import dev.acaica.server.communication.packet.Packet
import dev.acaica.server.communication.packet.PacketInformation
import dev.acaica.server.communication.types.VarInt

@PacketInformation(
        packetID = 0x00,
        state = CommunicationState.STATUS
)
class Response(val jsonLength: VarInt, val jsonResponse: String) : Packet() {
    constructor(responseGSON: ResponseGSON) : this(VarInt.fromInt(Gson().toJson(responseGSON).length), Gson().toJson(responseGSON))
    companion object {
        fun build(responseGSON: ResponseGSON): Response {
            val json = Gson().toJson(responseGSON)
            return Response(VarInt.fromInt(json.length), json)
        }
    }
}
class ResponseGSON(versionName: String, protocolVersion: Int, maxPlayers: Int, onlinePlayers: Int, /*TODO: description: JSONChat*/ val description: Map<String, Any>) {
    val version = mapOf<String, Any>("name" to versionName, "protocol" to protocolVersion)
    val players = mapOf<String, Any>("max" to maxPlayers, "online" to onlinePlayers, "sample" to listOf<Unit>())
}