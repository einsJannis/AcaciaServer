package dev.acaica.server.net.packet.out.play

import dev.acaica.server.JSONChat
import dev.acaica.server.net.packet.Packet

class Disconnect(val reason: JSONChat) : Packet