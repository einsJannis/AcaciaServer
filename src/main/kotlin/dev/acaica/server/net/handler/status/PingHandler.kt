package dev.acaica.server.net.handler.status

import dev.acaica.server.net.Client
import dev.acaica.server.net.handler.Handler
import dev.acaica.server.net.packet.`in`.status.Ping
import dev.acaica.server.net.packet.out.status.Pong

object PingHandler : Handler<Ping> {
    override fun handle(client: Client, packet: Ping) {
        client.sendPacket(Pong(packet.payload))
    }
}