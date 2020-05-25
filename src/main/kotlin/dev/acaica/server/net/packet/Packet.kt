package dev.acaica.server.net.packet

import dev.acaica.server.net.CommunicationState
import dev.acaica.server.net.packet.`in`.handshake.Handshake
import dev.acaica.server.net.packet.`in`.login.EncryptionResponse
import dev.acaica.server.net.packet.`in`.login.LoginPluginResponse
import dev.acaica.server.net.packet.`in`.login.LoginStart
import dev.acaica.server.net.packet.`in`.status.Request
import dev.acaica.server.net.types.VarInt
import dev.acaica.server.net.packet.`in`.status.Ping
import kotlin.reflect.KClass
import kotlin.reflect.KProperty1
import kotlin.reflect.full.companionObjectInstance
import kotlin.reflect.full.memberProperties

interface Packet {
    companion object {
        val inPackets: List<KClass<out Packet>> = listOf(
                Handshake::class,
                Ping::class,
                Request::class,
                EncryptionResponse::class,
                LoginPluginResponse::class,
                LoginStart::class
        )
    }
}
