package dev.acaica.server.communication.netty

import io.netty.channel.ChannelInitializer
import io.netty.channel.socket.SocketChannel

class ServerInitializer : ChannelInitializer<SocketChannel>() {
    override fun initChannel(channel: SocketChannel) {
        channel.pipeline().addLast(PacketDecoder())
        channel.pipeline().addLast(PacketEncoder())
        channel.pipeline().addLast(ServerInboundHandler())
    }
}