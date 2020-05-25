package dev.acaica.server.entity

import dev.acaica.server.JSONChat

interface CommandSender {
    fun sendMessage(message: JSONChat)
    fun sendWarning(message: JSONChat)
    fun sendError(message: JSONChat)
}
