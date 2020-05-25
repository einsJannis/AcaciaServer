package dev.acaica.server.net.packet.out.play

import dev.acaica.server.net.CommunicationState
import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.packet.PacketInformation
import dev.acaica.server.net.types.PacketPosition
import dev.acaica.server.net.types.VarInt

@PacketInformation(
        packetID = 0x0C,
        state = CommunicationState.PLAY,
        components = ["location", "blockID"]
)
class BlockChange(val location: PacketPosition, val blockID: VarInt) : Packet
