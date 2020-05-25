package dev.acaica.server

import dev.acaica.server.entity.Console
import dev.acaica.server.net.netty.ServerInitializer
import dev.acaica.server.entity.Player
import dev.acaica.server.extension.AcaciaExtension
import dev.acaica.server.types.ServerConfig
import io.netty.bootstrap.ServerBootstrap
import io.netty.channel.ChannelFuture
import io.netty.channel.ChannelOption
import io.netty.channel.EventLoopGroup
import io.netty.channel.nio.NioEventLoopGroup
import io.netty.channel.socket.nio.NioServerSocketChannel
import io.netty.handler.ssl.SslContextBuilder
import io.netty.handler.ssl.util.SelfSignedCertificate
import java.security.KeyPair
import java.security.KeyPairGenerator
import kotlin.concurrent.thread
import kotlin.system.exitProcess


object AcaciaServer {
    var running: Boolean = false
    val keyPair: KeyPair
    init {
        val keyPairGenerator = KeyPairGenerator.getInstance("RSA")
        keyPairGenerator.initialize(1024)
        keyPair = keyPairGenerator.generateKeyPair()
    }
    var ssc = SelfSignedCertificate()
    var sslCtx = SslContextBuilder.forServer(keyPair.private, ssc.cert())
            .build()
    val onlinePlayers: MutableList<Player> = mutableListOf()
    var config: ServerConfig = ServerConfig.default()
        internal set
    val port: Int
        get() = config.port
    var bossGroup: EventLoopGroup? = null
    var workerGroup: EventLoopGroup? = null
    var channelFuture: ChannelFuture? = null
    fun run() {
        running = true
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

    fun shutdown() {
        running = false
        AcaciaExtension.stopExtensions()
        stop()
        exitProcess(0)
    }
}

@ExperimentalUnsignedTypes
fun main(args: Array<String>) {
    /*val configFile = File("config.json")
    if (!configFile.exists()) {
        val configWriter = FileWriter(configFile)
        configWriter.write(Gson().toJson(ServerConfig.default()))
    }
    val configReader = FileReader(configFile)
    AcaciaServer.config = Gson().fromJson(configReader, ServerConfig::class.java)*/
    Logger.streams.put(System.out, Logger.LogLevel.valueOf(args[0].toUpperCase()))
    AcaciaExtension.loadExtensions()
    AcaciaServer.run()
    AcaciaExtension.startExtensions()
    thread { Console.listen() }
}
