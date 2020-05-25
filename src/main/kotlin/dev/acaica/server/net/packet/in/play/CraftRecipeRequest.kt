package dev.acaica.server.net.packet.`in`.play

import dev.acaica.server.net.CommunicationState
import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.packet.PacketInformation
import dev.acaica.server.types.Identifier

@PacketInformation (
        packetID = 0x18,
        state = CommunicationState.PLAY,
        components = ["windowID", "recipe", "makeAll"]
)

class CraftRecipeRequest : Packet {
    val windowID: Byte = 0x0
    val recipe: Identifier = Identifier("", "")
    val makeAll: Boolean = false
}