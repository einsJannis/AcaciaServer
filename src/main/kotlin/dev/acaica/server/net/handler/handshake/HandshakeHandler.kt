package dev.acaica.server.net.handler.handshake

import dev.acaica.server.net.Client
import dev.acaica.server.net.handler.Handler
import dev.acaica.server.net.packet.`in`.handshake.Handshake

object HandshakeHandler : Handler<Handshake> {
    @ExperimentalUnsignedTypes
    override fun handle(client: Client, packet: Handshake) {
        client.protocolVersion = packet.protocolVersion.toInt()
        client.serverAddress = packet.serverAddress
        client.serverPort = packet.serverPort
        client.state = packet.nextState
    }
}