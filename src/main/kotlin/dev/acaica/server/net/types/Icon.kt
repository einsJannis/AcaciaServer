package dev.acaica.server.net.types

import dev.acaica.server.JSONChat
import dev.acaica.server.net.CommunicationState
import dev.acaica.server.net.packet.PacketInformation

class Icon(
        val type: VarInt,
        val x: Byte,
        val y: Byte,
        val direction: Byte,
        val hasDisplayName: Boolean,
        val displayName: JSONChat?
)
