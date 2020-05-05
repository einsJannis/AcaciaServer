package dev.acaica.server.communication.netty

import dev.acaica.server.communication.Client
import dev.acaica.server.communication.packet.Packet
import dev.acaica.server.communication.types.VarInt
import io.netty.buffer.ByteBuf
import io.netty.channel.ChannelHandlerContext
import io.netty.handler.codec.ByteToMessageDecoder

class PacketDecoder : ByteToMessageDecoder() {
    override fun decode(ctx: ChannelHandlerContext, byteBuf: ByteBuf, out: MutableList<Any>) {
        println("decoding")
        val length = VarInt.readFromByteBuffer(byteBuf)
        println(length.toInt())
        val id = VarInt.readFromByteBuffer(byteBuf)
        println(id.toInt())
        val data = ByteArray(length.toInt() - id.toByteArray().size)
        println(data.size)
        byteBuf.readBytes(data)
        val packet = Packet.parsePacket(id.toInt(), Client.fromChannelID(ctx.channel().id()).state, data)
        println("created")
        out.add(packet)
        println("added")
    }
}