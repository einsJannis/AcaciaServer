package dev.acaica.server.net.packet.`in`.play

import dev.acaica.server.net.CommunicationState
import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.packet.PacketInformation
import dev.acaica.server.net.types.VarInt

@PacketInformation(
        packetID = 0x00,
        state = CommunicationState.PLAY,
        components = ["teleportID"]
)

class TeleportConfirm : Packet {
    var teleportID: VarInt = VarInt(byteArrayOf())
}