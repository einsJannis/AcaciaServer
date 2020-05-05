package dev.acaica.server

import dev.acaica.server.communication.netty.ServerInitializer
import io.netty.bootstrap.ServerBootstrap
import io.netty.channel.ChannelFuture
import io.netty.channel.ChannelOption
import io.netty.channel.EventLoopGroup
import io.netty.channel.nio.NioEventLoopGroup
import io.netty.channel.socket.nio.NioServerSocketChannel

class AcaciaServer(val port: Int) {
    var bossGroup: EventLoopGroup? = null
    var workerGroup: EventLoopGroup? = null
    var channelFuture: ChannelFuture? = null
    fun run() {
        try {
            bossGroup = NioEventLoopGroup()
            workerGroup = NioEventLoopGroup()
            val serverBootstrap = ServerBootstrap()
            serverBootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel::class.java)
                    .childHandler(ServerInitializer())
                    .option(ChannelOption.SO_BACKLOG, 128)
                    .childOption(ChannelOption.SO_KEEPALIVE, true)
            channelFuture = serverBootstrap.bind(port).sync()
        } catch (exce: Exception) {
            workerGroup?.shutdownGracefully()
            bossGroup?.shutdownGracefully()
        }
    }
    fun stop() {
        channelFuture?.channel()?.closeFuture()?.sync()
    }
}

fun main() {
    AcaciaServer(25565).run()
}