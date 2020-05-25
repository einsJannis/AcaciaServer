package dev.acaica.server.net.netty

import dev.acaica.server.net.types.VarInt
import io.netty.buffer.ByteBuf
import io.netty.channel.ChannelHandlerContext
import io.netty.handler.codec.ByteToMessageCodec
import kotlin.experimental.and


class FramingHandler : ByteToMessageCodec<ByteBuf>() {
    override fun encode(ctx: ChannelHandlerContext, msg: ByteBuf, out: ByteBuf) {
        out.writeBytes(VarInt.fromInt(msg.readableBytes()).toByteArray())
        out.writeBytes(msg)
    }

    override fun decode(ctx: ChannelHandlerContext, `in`: ByteBuf, out: MutableList<Any>) {
        `in`.markReaderIndex()
        if (!readableVarInt(`in`)) {
            return
        }
        val length: Int = VarInt.readFromByteBuffer(`in`).toInt()
        if (`in`.readableBytes() < length) {
            `in`.resetReaderIndex()
            return
        }
        val buf = ctx.alloc().buffer(length)
        `in`.readBytes(buf, length)
        out.add(buf)
    }

    companion object {
        private fun readableVarInt(buf: ByteBuf): Boolean {
            if (buf.readableBytes() > 5) {
                // maximum varint size
                return true
            }
            val idx = buf.readerIndex()
            var `in`: Byte
            do {
                if (buf.readableBytes() < 1) {
                    buf.readerIndex(idx)
                    return false
                }
                `in` = buf.readByte()
            } while (`in`.toInt() and 0x80 != 0)
            buf.readerIndex(idx)
            return true
        }
    }
}