package dev.acaica.server.net.netty

import com.google.gson.Gson
import dev.acaica.server.JSONChat
import dev.acaica.server.Logger
import dev.acaica.server.net.Client
import dev.acaica.server.net.CommunicationState
import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.packet.PacketInformation
import dev.acaica.server.net.types.*
import dev.acaica.server.toByteArray
import dev.acaica.server.types.Identifier
import dev.acaica.server.net.types.Angle
import io.netty.buffer.ByteBuf
import io.netty.channel.ChannelHandlerContext
import io.netty.handler.codec.MessageToMessageCodec
import java.io.ByteArrayOutputStream
import java.lang.StringBuilder
import java.nio.ByteBuffer
import java.nio.charset.Charset
import java.util.*
import kotlin.reflect.KClass
import kotlin.reflect.KMutableProperty
import kotlin.reflect.KProperty1
import kotlin.reflect.full.declaredMemberProperties
import kotlin.reflect.full.primaryConstructor

class PacketCodec : MessageToMessageCodec<ByteBuf, Packet>() {
    @ExperimentalUnsignedTypes
    override fun decode(ctx: ChannelHandlerContext, byteBuf: ByteBuf, out: MutableList<Any>) {
        Logger.debug("decoding")
        val id = VarInt.readFromByteBuffer(byteBuf)
        Logger.debug("id: ${id.toInt()}")
        val state = Client.fromChannelID(ctx.channel().id()).state
        Logger.debug("state: ${state.name}")
        var packetType: KClass<out Packet>? = null
        var packetInformation: PacketInformation? = null
        for (inPacket in Packet.inPackets) {
            val annotation = (inPacket.annotations.find { it is PacketInformation } as PacketInformation)
            if (annotation.packetID == id.toInt() && annotation.state == state) {
                packetType = inPacket
                packetInformation = annotation
            }
        }
        if (packetType != null && packetInformation != null) {
            Logger.debug("packetType: ${packetType.qualifiedName}")
            val stringBuilder = StringBuilder()
            stringBuilder.append("properties: [ ")
            packetInformation.components.forEach { stringBuilder.append("$it, ") }
            stringBuilder.removeSuffix(", ")
            stringBuilder.append("]")
            Logger.debug(stringBuilder.toString())
            val packet = packetType.primaryConstructor!!.call()
            for (propertyName in packetInformation.components) {
                Logger.debug("adding property $propertyName")
                val property = packetType.declaredMemberProperties.find { it.name == propertyName } as KMutableProperty<out Any>
                val propertyType = property.returnType
                Logger.debug("type: ${(propertyType.classifier as KClass<*>).qualifiedName}")
                property.setter.call(packet, parseValue(propertyType.classifier as KClass<out Any>, byteBuf))
            }
            out.add(packet)
            Logger.debug("added packet: $packet")
        } else {
            throw RuntimeException("Illegal Packet Received [${id.toInt()}, ${state.name}]")
        }
    }

    fun ByteBuf.readByteArrayWithLength(): ByteArray {
        val length = VarInt.readFromByteBuffer(this).toInt()
        val b = ByteArray(length)
        this.readBytes(b)
        return b
    }

    @ExperimentalUnsignedTypes
    private fun <T : Any> parseValue(valueType: KClass<T>, byteBuf: ByteBuf): T? {
        Logger.debug("parsingValue")
        val value = when (valueType) {
            Boolean::class -> byteBuf.readBoolean()
            Byte::class -> byteBuf.readByte()
            UByte::class -> byteBuf.readUnsignedByte().toUByte()
            Short::class -> byteBuf.readShort()
            UShort::class -> byteBuf.readUnsignedShort().toUShort()
            Int::class -> byteBuf.readInt()
            Long::class -> byteBuf.readLong()
            Float::class -> byteBuf.readFloat()
            Double::class -> byteBuf.readDouble()
            String::class -> String(byteBuf.readByteArrayWithLength(), charset("UTF-8"))
            JSONChat::class -> Gson().fromJson(String(byteBuf.readByteArrayWithLength(), charset("UTF-8")), JSONChat::class.java)
            Identifier::class -> Identifier.fromString(String(byteBuf.readByteArrayWithLength(), charset("UTF-8")))
            VarInt::class -> VarInt.readFromByteBuffer(byteBuf)
            VarLong::class -> VarLong.readFromByteBuffer(byteBuf)
            EntityMetadata::class -> EntityMetadata.readFromByteBuffer(byteBuf)
            SlotData::class -> SlotData.readFromByteBuffer(byteBuf)
            NBT::class -> NBT.readFromByteBuffer(byteBuf)
            PacketPosition::class -> PacketPosition(byteBuf.readLong())
            Angle::class -> Angle(byteBuf.readByte())
            UUID::class -> UUID.nameUUIDFromBytes(byteBuf.readBytes(16).array())
            ByteArray::class -> byteBuf.readByteArrayWithLength()
            CommunicationState::class -> CommunicationState.values()[VarInt.readFromByteBuffer(byteBuf).toInt()]
            //Optional::class ->
            //Array::class ->
            //Enum::class ->
            //ByteArray::class ->
            else -> throw RuntimeException("IllegalValueType")
        } as T
        Logger.debug("value: $value")
        return value
    }
    @ExperimentalUnsignedTypes
    override fun encode(ctx: ChannelHandlerContext, packet: Packet, out: MutableList<Any>) {
        val packetInformation = (packet::class.annotations.find { it is PacketInformation } as PacketInformation)
        val id = VarInt.fromInt(packetInformation.packetID)
        Logger.debug("Encoding packet: $packet")
        val byteArrayOutputStream = ByteArrayOutputStream()
        byteArrayOutputStream.write(id.toByteArray())
        val members = packet::class.declaredMemberProperties
        for (memberName in packetInformation.components) {
            val member = members.find { it.name == memberName } as KProperty1<Packet, *>
            Logger.debug("Adding property: $memberName")
            processPacketValue(member.get(packet), byteArrayOutputStream)
        }
        val buf = ctx.alloc().buffer()
        buf.writeBytes(byteArrayOutputStream.toByteArray())
        out.add(buf)
    }
    fun ByteArrayOutputStream.writeByteArrayWithLength(byteArray: ByteArray) {
        val size = VarInt.fromInt(byteArray.size)
        this.write(size.toByteArray())
        this.write(byteArray)
    }
    @ExperimentalUnsignedTypes
    fun processPacketValue(value: Any?, byteArrayOutputStream: ByteArrayOutputStream) {
        when (value) {
            is Nothing -> {}
            is Boolean -> byteArrayOutputStream.write(if (value) 1 else 0)
            is Byte -> byteArrayOutputStream.write(value.toInt())
            is UByte -> byteArrayOutputStream.write(value.toInt())
            is Short -> byteArrayOutputStream.write(value.toInt().toByteArray())
            is UShort -> byteArrayOutputStream.write(value.toInt().toByteArray())
            is Int -> byteArrayOutputStream.write(value.toByteArray())
            is Long -> byteArrayOutputStream.write(ByteBuffer.allocate(8).putLong(value).array())
            is Float -> byteArrayOutputStream.write(ByteBuffer.allocate(4).putFloat(value).array())
            is Double -> byteArrayOutputStream.write(ByteBuffer.allocate(8).putDouble(value).array())
            is String -> {
                if (value.length != 0) {
                    byteArrayOutputStream.writeByteArrayWithLength(value.toByteArray(Charset.forName("UTF-8")))
                } else {
                    byteArrayOutputStream.writeBytes(VarInt.fromInt(0).toByteArray())
                }
            }
            is JSONChat -> byteArrayOutputStream.writeByteArrayWithLength(Gson().toJson(value).toByteArray(Charset.forName("UTF-8")))
            is Identifier -> byteArrayOutputStream.writeByteArrayWithLength(value.toString().toByteArray(Charset.forName("UTF-8")))
            is VarInt -> byteArrayOutputStream.write(value.toByteArray())
            is VarLong -> byteArrayOutputStream.write(value.toByteArray())
            is EntityMetadata -> byteArrayOutputStream.write(value.toByteArray())
            is SlotData -> byteArrayOutputStream.write(value.toByteArray())
            is NBT -> byteArrayOutputStream.write(value.toByteArray())
            is PacketPosition -> byteArrayOutputStream.write(value.toByteArray())
            is Angle -> byteArrayOutputStream.write(value.toByteArray())
            is UUID -> byteArrayOutputStream.write(value.toByteArray())
            is Array<*> -> value.forEach { processPacketValue(it, byteArrayOutputStream) }
            is Enum<*> -> byteArrayOutputStream.write(VarInt.fromInt(value.ordinal).toByteArray())
            is ByteArray -> byteArrayOutputStream.write(value)
        }
    }
}