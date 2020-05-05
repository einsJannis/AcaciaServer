package dev.acaica.server.communication.packet

import dev.acaica.server.communication.Client
import dev.acaica.server.communication.CommunicationState
import dev.acaica.server.communication.packet.`in`.handshake.Handshake
import dev.acaica.server.communication.packet.`in`.login.EncryptionResponse
import dev.acaica.server.communication.packet.`in`.login.LoginPluginResponse
import dev.acaica.server.communication.packet.`in`.login.LoginStart
import dev.acaica.server.communication.packet.`in`.status.Request
import dev.acaica.server.communication.types.VarInt
import dev.einsjannis.kms.commmunication.packet.server.status.Ping
import kotlin.reflect.KClass
import kotlin.reflect.KFunction
import kotlin.reflect.KProperty1
import kotlin.reflect.full.companionObject
import kotlin.reflect.full.memberFunctions
import kotlin.reflect.full.memberProperties

abstract class Packet {
    companion object {
        private val packets: List<KClass<*>> = listOf(
                Handshake::class,
                Ping::class,
                Request::class,
                EncryptionResponse::class,
                LoginPluginResponse::class,
                LoginStart::class
        )
        fun parsePacket(packetID: Int, state: CommunicationState, data: ByteArray) = getPacketBuilder(packetID, state).call(data)!!
        fun getPacketBuilder(packetID: Int, state: CommunicationState): KFunction<*> {
            val packet = packets.find {
                val annotation = it.annotations.find { it is PacketInformation } as PacketInformation
                println("${it.qualifiedName} -> ${annotation.packetID == packetID && annotation.state == state}")
                return@find annotation.packetID == packetID && annotation.state == state
            }!!
            println("found -> ${packet.qualifiedName}")
            val packetCompanion = packet.companionObject!!
            println("found -> ${packetCompanion.qualifiedName}")
            val packetBuilderFunction = packetCompanion.memberFunctions.find { it.name == "build" }!!
            println("found -> ${packetBuilderFunction.name}")
            return packetBuilderFunction
        }

        @ExperimentalUnsignedTypes
        fun packetSize(packet: Packet) {
            var size = 0
            var pClass = packet::class
            size += VarInt.fromInt(
                    (pClass.annotations.find { it is PacketInformation } as PacketInformation).packetID
            ).toByteArray().size
            pClass.memberProperties.forEach {
                val parameter = (it as KProperty1<Packet, *>).get(packet)
                size += when (parameter) {
                    is VarInt -> parameter.toByteArray().size
                    is Int -> Int.SIZE_BYTES
                    is ULong -> ULong.SIZE_BYTES
                    is Long -> Long.SIZE_BYTES
                    is ULong -> ULong.SIZE_BYTES
                    is String -> parameter.length
                    is Short -> Short.SIZE_BYTES
                    is UShort -> UShort.SIZE_BYTES
                    else -> throw RuntimeException()
                }
            }
        }
    }
}

typealias PacketBuilder = (ByteArray) -> Packet
