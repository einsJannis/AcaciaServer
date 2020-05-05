package dev.acaica.server.communication.packet.out.login

import dev.acaica.server.communication.CommunicationState
import dev.acaica.server.communication.packet.Packet
import dev.acaica.server.communication.packet.PacketInformation
import dev.acaica.server.communication.types.VarInt
/*import sun.tools.java.Identifier*/

@PacketInformation(
        packetID = 0x04,
        state = CommunicationState.LOGIN
)
class LoginPluginRequest(messageID: VarInt/*, channel: Identifier*/, data: ByteArray) : Packet()