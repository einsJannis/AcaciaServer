package dev.acaica.server.net.packet.out.play

import dev.acaica.server.net.CommunicationState
import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.packet.PacketInformation
import dev.acaica.server.net.types.NBT
import dev.acaica.server.net.types.PacketPosition

@PacketInformation(
        packetID = 0x0A,
        state = CommunicationState.PLAY,
        components = ["location", "action", "nbtData"]
)
class BlockEntityData(val location: PacketPosition, val action: UByte, val nbtData: NBT) : Packet