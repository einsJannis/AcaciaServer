package dev.acaica.server.net.packet.out.play

import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.types.VarInt

class TabComplete(val id: VarInt, val start: VarInt, val length: VarInt, val count: VarInt) : Packet