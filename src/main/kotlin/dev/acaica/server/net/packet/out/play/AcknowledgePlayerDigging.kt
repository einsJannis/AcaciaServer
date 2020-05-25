package dev.acaica.server.net.packet.out.play

import dev.acaica.server.net.CommunicationState
import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.packet.PacketInformation
import dev.acaica.server.net.types.PacketPosition
import dev.acaica.server.net.types.VarInt

@PacketInformation(
        packetID = 0x08,
        state = CommunicationState.PLAY,
        components = ["location", "block", "status", "successful"]
)
class AcknowledgePlayerDigging(val location: PacketPosition, val block: VarInt, val status: VarInt, val successful: Boolean) : Packet