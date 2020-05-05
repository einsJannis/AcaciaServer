package dev.acaica.server.communication.netty

import dev.acaica.server.communication.packet.Packet
import dev.acaica.server.communication.packet.PacketInformation
import dev.acaica.server.communication.types.VarInt
import io.netty.buffer.ByteBuf
import io.netty.channel.ChannelHandlerContext
import io.netty.handler.codec.MessageToByteEncoder

class PacketEncoder : MessageToByteEncoder<Packet>() {
    override fun encode(ctx: ChannelHandlerContext, packet: Packet, byteBuf: ByteBuf) {
        Packet.packetSize(packet)
        val id = VarInt.fromInt((packet::class.annotations.find { it is PacketInformation } as PacketInformation).packetID)
        byteBuf.writeBytes(id.toByteArray())
    }
}