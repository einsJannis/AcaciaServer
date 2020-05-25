package dev.acaica.server.net.packet.out.play

import dev.acaica.server.net.CommunicationState
import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.packet.PacketInformation
import dev.acaica.server.net.types.Icon
import dev.acaica.server.net.types.VarInt

@PacketInformation(
        packetID = 0x27,
        state = CommunicationState.PLAY,
        components = ["mapID", "scale", "trackingPosition", "locked", "iconCount", "icons", "columns", "rows", "x", "z", "length", "data"]
)
class MapData(
        val mapID: VarInt,
        val scale: Byte,
        val trackingPosition: Boolean,
        val locked: Boolean,
        val iconCount: VarInt,
        val icons: Array<Icon>,
        val columns: UByte,
        val rows: Byte?,
        val x: Byte?,
        val z: Byte?,
        val length: VarInt?,
        val data: Array<UByte>?
) : Packet