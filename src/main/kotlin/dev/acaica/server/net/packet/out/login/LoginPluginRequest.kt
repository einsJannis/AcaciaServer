package dev.acaica.server.net.packet.out.login

import dev.acaica.server.net.CommunicationState
import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.packet.PacketInformation
import dev.acaica.server.net.types.VarInt
import dev.acaica.server.types.Identifier

/*import sun.tools.java.Identifier*/

@PacketInformation(
        packetID = 0x04,
        state = CommunicationState.LOGIN,
        components = ["messageID", "data"]
)
class LoginPluginRequest(val messageID: VarInt, val channel: Identifier, val data: ByteArray) : Packet