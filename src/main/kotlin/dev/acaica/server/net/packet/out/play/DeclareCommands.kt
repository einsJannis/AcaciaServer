package dev.acaica.server.net.packet.out.play

import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.types.Node
import dev.acaica.server.net.types.VarInt

class DeclareCommands(val count: VarInt, val nodes: Array<Node>, val rootIndex: VarInt) : Packet