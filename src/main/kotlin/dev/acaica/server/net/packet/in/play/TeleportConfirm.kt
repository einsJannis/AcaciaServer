package dev.acaica.server.net.packet.`in`.play

import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.types.VarInt

class TeleportConfirm(val teleportID: VarInt) : Packet