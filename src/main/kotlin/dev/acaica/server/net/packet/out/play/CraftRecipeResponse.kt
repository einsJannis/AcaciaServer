package dev.acaica.server.net.packet.out.play

import dev.acaica.server.net.CommunicationState
import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.packet.PacketInformation
import dev.acaica.server.types.Identifier

@PacketInformation(
        packetID = 0x31,
        state = CommunicationState.PLAY,
        components = ["windowID", "recipe"]
)
class CraftRecipeResponse(val windowID: Byte, val recipe: Identifier) : Packet