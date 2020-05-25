package dev.acaica.server.net.packet.`in`.play

import dev.acaica.server.net.CommunicationState
import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.packet.PacketInformation
import dev.acaica.server.net.types.PacketPosition
import dev.acaica.server.net.types.VarInt
import dev.acaica.server.net.types.VarLong

@PacketInformation (
        packetID = 0x28,
        state = CommunicationState.PLAY,
        components = ["location", "action", "mode", "name", "offsetX", "offsetY", "offsetZ", "sizeX", "sizeY", "sizeZ", "mirror", "rotation", "metadata", "integrity", "seed", "flags"]
)

class UpdateStructureBlock : Packet {
    val Location: PacketPosition = PacketPosition(0)
    val action: VarInt = VarInt(byteArrayOf())
    val mode: VarInt = VarInt(byteArrayOf())
    val name: String = ""
    val offsetX: Byte = 0x00
    val offsetY: Byte = 0x00
    val offsetZ: Byte = 0x00
    val sizeX: Byte = 0x00
    val sizeY: Byte = 0x00
    val sizeZ: Byte = 0x00
    val mirror: VarInt = VarInt(byteArrayOf())
    val rotation: VarInt = VarInt(byteArrayOf())
    val metadata: String = ""
    val integrity: Float = 0f
    val seed: VarLong = VarLong(byteArrayOf())
    val flags: Byte = 0x00
}