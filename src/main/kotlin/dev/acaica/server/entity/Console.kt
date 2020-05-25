package dev.acaica.server.entity

import dev.acaica.server.AcaciaServer
import dev.acaica.server.JSONChat
import dev.acaica.server.Logger
import dev.acaica.server.command.Command
import java.util.*

object Console : CommandSender {
    override fun sendMessage(message: JSONChat) {
        Logger.info(message.text)
    }
    override fun sendWarning(message: JSONChat) {
        Logger.warn(message.text)
    }
    override fun sendError(message: JSONChat) {
        Logger.error(message.text)
    }

    fun listen() {
        while (AcaciaServer.running) {
            val scanner = Scanner(System.`in`)
            val command = scanner.nextLine()
            Command.parseAndRunCommand(command, this)
        }
    }
}