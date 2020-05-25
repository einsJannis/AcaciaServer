package dev.acaica.server.net.packet.out.play

import dev.acaica.server.net.CommunicationState
import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.packet.PacketInformation
import dev.acaica.server.net.types.MultiBlockRecord

@PacketInformation(
        packetID = 0x1D,
        state = CommunicationState.PLAY,
        components = ["x", "y", "z", "strength", "recordCount", "records"]
)
class Explosion(
        val x: Float,
        val y: Float,
        val z: Float,
        val strength: Float,
        val recordCount: Int,
        val records: Array<MultiBlockRecord>,
        val playerMotionX: Float,
        val playerMotionY: Float,
        val playerMotionZ: Float
) : Packet