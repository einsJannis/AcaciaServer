package dev.acaica.server.event

import dev.acaica.server.net.Client
import dev.acaica.server.net.packet.Packet

class PacketReceivedEvent(val packet: Packet, val client: Client) : Event
