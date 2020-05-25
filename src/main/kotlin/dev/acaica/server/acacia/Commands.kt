package dev.acaica.server.acacia

import dev.acaica.server.AcaciaServer
import dev.acaica.server.JSONChat
import dev.acaica.server.command.argument.CommandArgument
import dev.acaica.server.command.argument.type.JSON
import dev.acaica.server.command.argument.type.PlayerName
import dev.acaica.server.command.commandSet
import dev.acaica.server.net.packet.out.login.Disconnect
import java.lang.StringBuilder

object Commands {
    val defaultCommands =
            commandSet {
                command("stop") {
                    run { _, commandSender ->
                        commandSender.sendMessage(JSONChat("Server shutting down..."))
                        AcaciaServer.stop()
                        return@run true
                    }
                }
                command("players") {
                    subCommands {
                        command("list") {
                            run { _, commandSender ->
                                val stringBuilder = StringBuilder()
                                stringBuilder.append("Online Players:")
                                AcaciaServer.onlinePlayers.forEach {
                                    stringBuilder.append("${it.username}\n")
                                }
                                commandSender.sendMessage(JSONChat(stringBuilder.toString()))
                                return@run true
                            }
                        }
                    }
                }
            }
    val moderationCommands =
            commandSet {
                command("kick") {
                    run (CommandArgument("player", PlayerName::class, false), CommandArgument("reason", JSON::class, true)) { args, commandSender ->
                        val playerName = (args["player"] as PlayerName)
                        if (playerName.isValid()) {
                            val reason = (args["reason"] as JSON).toJSONChat()
                            playerName.toPlayer()!!.client.sendPacket(Disconnect(reason))
                            commandSender.sendMessage(JSONChat("Kicked Player $playerName"))
                            return@run true
                        }
                        commandSender.sendMessage(JSONChat("No player with the name $playerName"))
                        return@run false
                    }
                }
            }
}
