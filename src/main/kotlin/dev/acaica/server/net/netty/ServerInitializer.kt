package dev.acaica.server.net.netty

import io.netty.channel.ChannelInitializer
import io.netty.channel.socket.SocketChannel

class ServerInitializer : ChannelInitializer<SocketChannel>() {
    override fun initChannel(channel: SocketChannel) {
        channel.pipeline().addLast("framingHandler", FramingHandler())
        channel.pipeline().addLast("packetCodec", PacketCodec())
        channel.pipeline().addLast("inboundHandler", ServerInboundHandler())
    }
}