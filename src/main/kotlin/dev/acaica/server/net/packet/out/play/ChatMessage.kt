package dev.acaica.server.net.packet.out.play

import dev.acaica.server.JSONChat

class ChatMessage(jsonData: String, position: Byte) {
    constructor(jsonData: JSONChat, position: Byte) : this(jsonData.toString(), position)
}
