package dev.acaica.server.net.packet.out.play

import dev.acaica.server.net.packet.Packet

class WindowProperty(val windowID: UByte, val property: Short, val value: Short) : Packet