package dev.acaica.server.net.packet.out.play

import dev.acaica.server.net.CommunicationState
import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.packet.PacketInformation
import dev.acaica.server.net.types.Node
import dev.acaica.server.net.types.VarInt

@PacketInformation(
        packetID = 0x12,
        state = CommunicationState.PLAY,
        components = ["count", "nodes", "rootIndex"]
)
class DeclareCommands(val count: VarInt, val nodes: Array<Node>, val rootIndex: VarInt) : Packet