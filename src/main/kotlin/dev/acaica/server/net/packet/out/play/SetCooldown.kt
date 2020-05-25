package dev.acaica.server.net.packet.out.play

import dev.acaica.server.net.packet.Packet
import dev.acaica.server.net.types.VarInt

class SetCooldown(val itemID: VarInt, val cooldownTicks: VarInt) : Packet