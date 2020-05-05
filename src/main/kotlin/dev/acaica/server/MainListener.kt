package dev.acaica.server

import dev.acaica.server.communication.packet.`in`.handshake.Handshake
import dev.acaica.server.communication.packet.`in`.status.Request
import dev.acaica.server.communication.packet.out.status.Response
import dev.acaica.server.communication.packet.out.status.ResponseGSON
import dev.acaica.server.event.EventListener
import dev.acaica.server.event.PacketReceivedEvent

object MainListener : EventListener {
    @ExperimentalUnsignedTypes
    fun onPacketReceived(event: PacketReceivedEvent) {
        print("EventCalled")
        val packet = event.packet
        val client = event.client
        when (packet) {
            is Handshake -> {
                client.protocolVersion = packet.protocolVersion.toInt()
                client.serverAddress = packet.serverAddress
                client.serverPort = packet.serverPort
                client.state = packet.nextState
            }
            is Request -> {
                client.sendPacket(Response.build(ResponseGSON("Acacia Server", 678, 20, 0, mapOf(
                        "text" to "This was a successful test"
                ))))
            }
        }
    }
}