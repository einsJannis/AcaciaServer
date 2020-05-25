package dev.acaica.server.net.packet.out.play

import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.types.VarInt

class EntityAnimation(val entityID: VarInt, val animation: UByte) : Packet