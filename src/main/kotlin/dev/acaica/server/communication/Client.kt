package dev.acaica.server.communication

import dev.acaica.server.communication.packet.Packet
import dev.acaica.server.communication.packet.PacketInformation
import io.netty.channel.Channel
import io.netty.channel.ChannelId
import java.lang.RuntimeException
import kotlin.reflect.full.hasAnnotation

class Client(val channel: Channel) {

    var state: CommunicationState = CommunicationState.HANDSHAKING
    var protocolVersion: Int? = null
    var serverAddress: String? = null
    @ExperimentalUnsignedTypes
    var serverPort: UShort? = null

    init {
        clients.add(this)
    }

    fun delete() {
        clients.remove(this)
    }

    fun sendPacket(packet: Packet) = channel.write(packet)

    companion object {
        val clients: MutableCollection<Client> = mutableListOf()

        fun fromChannelID(channelId: ChannelId): Client {
            return clients.find { it.channel.id() == channelId } ?: throw RuntimeException()
        }
    }

}