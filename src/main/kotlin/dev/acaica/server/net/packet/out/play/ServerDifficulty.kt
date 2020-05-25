package dev.acaica.server.net.packet.out.play

import dev.acaica.server.net.packet.Packet

class ServerDifficulty(val difficulty: Byte, val difficultyLocked: Boolean) : Packet