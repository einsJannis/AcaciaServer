package dev.acaica.server.net.netty

import dev.acaica.server.net.Client
import dev.acaica.server.net.packet.Packet
import dev.acaica.server.event.Event
import dev.acaica.server.event.PacketReceivedEvent
import dev.acaica.server.net.handler.Handler
import dev.acaica.server.net.handler.handshake.HandshakeHandler
import dev.acaica.server.net.handler.login.EncryptionResponseHandler
import dev.acaica.server.net.handler.login.LoginStartHandler
import dev.acaica.server.net.handler.status.PingHandler
import dev.acaica.server.net.handler.status.RequestHandler
import dev.acaica.server.net.packet.`in`.handshake.Handshake
import dev.acaica.server.net.packet.`in`.login.EncryptionResponse
import dev.acaica.server.net.packet.`in`.login.LoginStart
import dev.acaica.server.net.packet.`in`.status.Ping
import dev.acaica.server.net.packet.`in`.status.Request
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.ChannelInboundHandler

class ServerInboundHandler : ChannelInboundHandler {

    override fun channelInactive(ctx: ChannelHandlerContext) {
        Client.fromChannelID(ctx.channel().id()).delete()
    }

    override fun userEventTriggered(ctx: ChannelHandlerContext?, event: Any?) {

    }

    override fun channelWritabilityChanged(ctx: ChannelHandlerContext?) {

    }

    @ExperimentalStdlibApi
    override fun channelRead(ctx: ChannelHandlerContext, message: Any) {
        val packet = message as Packet
        val handler: Handler<Packet> = when (message) {
            is Handshake -> HandshakeHandler
            is Request -> RequestHandler
            is Ping -> PingHandler
            is LoginStart -> LoginStartHandler
            is EncryptionResponse -> EncryptionResponseHandler
            else -> throw RuntimeException("IllegalPacket")
        } as Handler<Packet>
        handler.handle(Client.fromChannelID(ctx.channel().id()), packet)
    }

    override fun channelUnregistered(ctx: ChannelHandlerContext?) {

    }

    override fun channelActive(ctx: ChannelHandlerContext) {
        Client(ctx.channel())
    }

    override fun channelRegistered(ctx: ChannelHandlerContext?) {

    }

    override fun channelReadComplete(ctx: ChannelHandlerContext?) {

    }

    override fun handlerAdded(ctx: ChannelHandlerContext?) {

    }

    override fun exceptionCaught(ctx: ChannelHandlerContext?, cause: Throwable?) {

    }

    override fun handlerRemoved(ctx: ChannelHandlerContext?) {

    }
}