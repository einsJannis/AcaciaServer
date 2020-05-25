package dev.acaica.server.net.packet

import dev.acaica.server.net.CommunicationState

annotation class PacketInformation(val packetID: Int, val state: CommunicationState, val components: Array<String>)