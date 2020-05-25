package dev.acaica.server.net.handler

import dev.acaica.server.net.Client
import dev.acaica.server.net.packet.Packet

interface Handler<T : Packet> {
    fun handle(client: Client, packet: T)
}