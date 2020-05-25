package dev.acaica.server.net.packet.out.play

import dev.acaica.server.JSONChat
import dev.acaica.server.net.CommunicationState
import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.packet.PacketInformation
import dev.acaica.server.net.types.VarInt

@PacketInformation(
        packetID = 0x2F,
        state = CommunicationState.PLAY,
        components = ["windowID", "windowType", "windowTitle"]
)
class OpenWindow(val windowID: VarInt, val windowType: VarInt, val windowTitle: JSONChat) : Packet