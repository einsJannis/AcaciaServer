package dev.acaica.server.net.packet.out.play

import dev.acaica.server.net.packet.Packet

class WindowConfirmation(val windowID: Byte, val actionNumber: Short, val accepted: Boolean) : Packet