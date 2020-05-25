package dev.acaica.server.net.packet.out.play

import dev.acaica.server.net.packet.Packet
import dev.acaica.server.types.Identifier

class PluginMessage(val channel: Identifier, val data: ByteArray) : Packet