package dev.acaica.server.net.packet.out.play

import dev.acaica.server.net.CommunicationState
import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.packet.PacketInformation

@PacketInformation(
        packetID = 0x0E,
        state = CommunicationState.PLAY,
        components = ["difficulty", "difficultyLocked"]
)
class ServerDifficulty(val difficulty: Byte, val difficultyLocked: Boolean) : Packet