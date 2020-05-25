package dev.acaica.server.command

import dev.acaica.server.Logger
import dev.acaica.server.command.argument.CommandArgument
import dev.acaica.server.command.argument.CommandArgumentList
import dev.acaica.server.command.argument.type.CommandArgumentType
import dev.acaica.server.entity.CommandSender
import dev.acaica.server.inc

class Command private constructor() {
    var subCommands: CommandSet = CommandSet.emptyCommandSet()
        private set
    var run: CommandRunnable? = null
        private set
    var arguments: MutableList<CommandArgument<out CommandArgumentType>> = mutableListOf()
    val argumentCount: IntRange
        get() = arguments.filter { !it.optional }.size..arguments.size
    class Builder internal constructor() {
        internal val command = Command()
        fun subCommands(subCommands: CommandSet.Builder.() -> Unit) {
            val setBuilder = CommandSet.Builder()
            subCommands(setBuilder)
            command.subCommands = setBuilder.commandSet
        }
        fun run(vararg arguments: CommandArgument<out CommandArgumentType>, run: CommandRunnable) {
            command.run = run
            command.arguments.addAll(arguments.toList())
        }
        fun run(run: CommandRunnable) {
            command.run = run
        }
    }
    companion object {
        fun parseAndRunCommand(command: String, commandSender: CommandSender) {
            Logger.debug("Parsing command: $command")
            val parts = getCommandParts(command)
            var currentCommand = (CommandSet.registeredCommandSets.find { it.containsKey(parts[0]) } ?: throw CommandParseException("No such command"))[parts[0]]!!
            for (i in 1..parts.lastIndex) {
                if (isNormalPart(parts[i]) && currentCommand.subCommands.containsKey(parts[i])) {
                    currentCommand = currentCommand.subCommands[parts[i]]!!
                } else if (currentCommand.argumentCount.contains(parts.size - i)) {
                    currentCommand.run!!.invoke(CommandArgumentList.parse(parts.subList(i, parts.lastIndex), currentCommand.arguments), commandSender)
                } else throw CommandParseException("No such command")
            }
        }
        fun tapComplete(command: String): Collection<String> {
            val parts = getCommandParts(command)
            var currentCommand = (CommandSet.registeredCommandSets.find { it.containsKey(parts[0]) } ?: throw CommandParseException("No such command"))[parts[0]]!!
            for (i in 1 until parts.size) {
                if (isNormalPart(parts[i]) && currentCommand.subCommands.containsKey(parts[i])) {
                    currentCommand = currentCommand.subCommands[parts[i]]!!
                    if (i == parts.lastIndex) return currentCommand.subCommands.keys
                } else if (currentCommand.argumentCount == 0..0) {
                    currentCommand.arguments[parts.size-i]
                } else throw CommandParseException("No such command")
            }
            TODO()
        }
        private fun usageMessage(command: String): String {
            TODO()
        }
        private fun getCommandParts(command: String): MutableList<String> {
            val parts: MutableList<String> = mutableListOf()
            var lastEnd = -1
            var openString = false
            var openArray = 0
            var openObjects = 0
            for (i in command.indices) {
                if (i == command.lastIndex) {
                    parts.add(command.substring(lastEnd + 1, i + 1))
                    break
                }
                when (command[i]) {
                    ' ' -> {
                        if (!openString && openObjects == 0 && openArray == 0) {
                            parts.add(command.substring(lastEnd + 1, i - 1))
                            lastEnd = i
                        }
                    }
                    '"' -> if (command[i-1] != '\\') openString++
                    '[' -> if (command[i-1] != '\\') openArray++
                    ']' -> if (command[i-1] != '\\') openArray--
                    '{' -> if (command[i-1] != '\\') openObjects++
                    '}' -> if (command[i-1] != '\\') openObjects--
                }
            }
            return parts
        }
        private fun isNormalPart(part: String) = !part.startsWith('"') || !part.startsWith('[') || !part.startsWith('{')
    }
}

typealias CommandRunnable = (args: CommandArgumentList, commandSender: CommandSender) -> Boolean