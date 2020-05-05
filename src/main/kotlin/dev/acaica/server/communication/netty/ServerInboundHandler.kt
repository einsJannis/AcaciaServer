package dev.acaica.server.communication.netty

import dev.acaica.server.communication.Client
import dev.acaica.server.communication.packet.Packet
import dev.acaica.server.event.EventHandler
import dev.acaica.server.event.PacketReceivedEvent
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

    override fun channelRead(ctx: ChannelHandlerContext, message: Any) {
        print(message.toString())
        EventHandler.callEvent(PacketReceivedEvent(message as Packet, Client.fromChannelID(ctx.channel().id())))
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