package dev.acaica.server.event

import dev.acaica.server.communication.Client
import dev.acaica.server.communication.packet.Packet
import io.netty.channel.Channel

class PacketReceivedEvent(val packet: Packet, val client: Client) : Event
