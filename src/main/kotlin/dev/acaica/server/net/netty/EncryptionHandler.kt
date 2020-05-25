package dev.acaica.server.net.netty

import io.netty.buffer.ByteBuf
import io.netty.buffer.Unpooled
import io.netty.channel.ChannelHandlerContext
import io.netty.handler.codec.MessageToMessageCodec
import java.nio.ByteBuffer
import java.security.GeneralSecurityException
import javax.crypto.Cipher
import javax.crypto.SecretKey
import javax.crypto.ShortBufferException
import javax.crypto.spec.IvParameterSpec


class EncryptionHandler(sharedSecret: SecretKey) : MessageToMessageCodec<ByteBuf, ByteBuf>() {
    private var encodeBuf: CryptBuf? = null
    private var decodeBuf: CryptBuf? = null

    @Throws(Exception::class)
    override fun encode(ctx: ChannelHandlerContext, msg: ByteBuf, out: MutableList<Any>) {
        encodeBuf!!.crypt(msg, out)
    }

    @Throws(Exception::class)
    override fun decode(ctx: ChannelHandlerContext, msg: ByteBuf, out: MutableList<Any>) {
        decodeBuf!!.crypt(msg, out)
    }

    private class CryptBuf internal constructor(mode: Int, sharedSecret: SecretKey) {
        private val cipher: Cipher
        fun crypt(msg: ByteBuf, out: MutableList<Any>) {
            val outBuffer: ByteBuffer = ByteBuffer.allocate(msg.readableBytes())
            try {
                cipher.update(msg.nioBuffer(), outBuffer)
            } catch (e: ShortBufferException) {
                throw AssertionError("Encryption buffer was too short", e)
            }
            outBuffer.flip()
            out.add(Unpooled.wrappedBuffer(outBuffer))
        }

        init {
            cipher = Cipher.getInstance("AES/CFB8/NoPadding") // NON-NLS
            cipher.init(mode, sharedSecret, IvParameterSpec(sharedSecret.encoded))
        }
    }

    /**
     * Creates an instance that applies symmetrical AES encryption.
     *
     * @param sharedSecret an AES key
     */
    init {
        try {
            encodeBuf = CryptBuf(Cipher.ENCRYPT_MODE, sharedSecret)
            decodeBuf = CryptBuf(Cipher.DECRYPT_MODE, sharedSecret)
        } catch (e: GeneralSecurityException) {
            //TODO: error handling
            throw AssertionError("Failed to initialize encrypted channel", e)
        }
    }
}