package dev.acaica.server.net.packet.out.play

import dev.acaica.server.net.CommunicationState
import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.packet.PacketInformation
import dev.acaica.server.net.types.SlotData
import dev.acaica.server.net.types.VarInt

@PacketInformation(
        packetID = 0x24,
        state = CommunicationState.PLAY,
        components = ["particleID", "longDistance", "x", "y", "z", "offsetX", "offsetY", "offsetZ", "particleData", "particleCount", "blockState", "red", "green", "blue", "scale", "item"]
)
class Particle(
        val particleID: Int,
        val longDistance: Boolean,
        val x: Double,
        val y: Double,
        val z: Double,
        val offsetX: Float,
        val offsetY: Float,
        val offsetZ: Float,
        val particleData: Float,
        val particleCount: Float,
        val blockState: VarInt?,
        val red: VarInt?,
        val green: VarInt?,
        val blue: VarInt?,
        val scale: Float?,
        val item: SlotData?
) : Packet