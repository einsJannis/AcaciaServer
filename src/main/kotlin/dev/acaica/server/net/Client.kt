package dev.acaica.server.net

import dev.acaica.server.net.packet.Packet
import dev.acaica.server.toByteArray
import io.netty.channel.Channel
import io.netty.channel.ChannelFuture
import io.netty.channel.ChannelId
import java.lang.RuntimeException
import kotlin.random.Random

class Client(val channel: Channel) {

    var username: String? = null
    var state: CommunicationState = CommunicationState.HANDSHAKING
    var protocolVersion: Int? = null
    var serverAddress: String? = null
    @ExperimentalUnsignedTypes
    var serverPort: UShort? = null
    var verifyToken: ByteArray = Random.nextInt().toByteArray()

    init {
        clients.add(this)
    }

    fun delete() {
        clients.remove(this)
    }

    fun sendPacket(packet: Packet): ChannelFuture = channel.writeAndFlush(packet)

    companion object {
        val clients: MutableCollection<Client> = mutableListOf()

        fun fromChannelID(channelId: ChannelId): Client {
            return clients.find { it.channel.id() == channelId } ?: throw RuntimeException()
        }
    }

}