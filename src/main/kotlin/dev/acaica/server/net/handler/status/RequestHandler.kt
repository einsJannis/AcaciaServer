package dev.acaica.server.net.handler.status

import dev.acaica.server.AcaciaServer
import dev.acaica.server.net.Client
import dev.acaica.server.net.handler.Handler
import dev.acaica.server.net.packet.`in`.status.Request
import dev.acaica.server.net.packet.out.status.Response

object RequestHandler : Handler<Request> {
    override fun handle(client: Client, packet: Request) {
        client.sendPacket(Response.fromServerConfig(AcaciaServer.config))
    }
}