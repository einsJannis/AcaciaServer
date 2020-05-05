package dev.acaica.server.communication.packet

import dev.acaica.server.communication.CommunicationState

annotation class PacketInformation(val packetID: Int, val state: CommunicationState)