package dev.acaica.server.command.argument

import dev.acaica.server.command.argument.type.CommandArgumentType
import java.lang.Exception

class CommandArgumentList : List<CommandArgumentType> {
    private var keys: MutableList<String> = mutableListOf()
    private var values: MutableList<CommandArgumentType> = mutableListOf()
    operator fun get(name: String): CommandArgumentType {
        return values.get(keys.indexOf(name))
    }

    companion object {
        fun parse(args: List<String>, cmdArgs: List<CommandArgument<out CommandArgumentType>>): CommandArgumentList {
            val arguments = CommandArgumentList()
            var cmdI = 0
            for (arg in args) {
                val success = false
                while (!success) {
                    if (cmdI > cmdArgs.size) throw RuntimeException("UnableToParseCommandArgs")
                    val commandArgument = cmdArgs[cmdI]
                    val commandArgumentValue: CommandArgumentType
                    try {
                        commandArgumentValue = commandArgument.parse(arg)
                    } catch (exce: Exception) {
                        cmdI++
                        continue
                    }
                    arguments.keys.add(cmdArgs[cmdI].name)
                    arguments.values.add(commandArgumentValue)
                }
            }
            return arguments
        }
    }

    override val size: Int
        get() = values.size

    override fun contains(element: CommandArgumentType): Boolean = values.contains(element)

    override fun containsAll(elements: Collection<CommandArgumentType>): Boolean = values.containsAll(elements)

    override fun get(index: Int): CommandArgumentType = values[index]

    override fun indexOf(element: CommandArgumentType): Int = values.indexOf(element)

    override fun isEmpty(): Boolean = values.isEmpty()

    override fun iterator(): Iterator<CommandArgumentType> = values.iterator()

    override fun lastIndexOf(element: CommandArgumentType): Int = values.lastIndexOf(element)

    override fun listIterator(): ListIterator<CommandArgumentType> = values.listIterator()

    override fun listIterator(index: Int): ListIterator<CommandArgumentType> = values.listIterator(index)

    override fun subList(fromIndex: Int, toIndex: Int): CommandArgumentList {
        val commandArgumentList = CommandArgumentList()
        commandArgumentList.keys = keys.subList(fromIndex, toIndex)
        commandArgumentList.values = values.subList(fromIndex, toIndex)
        return commandArgumentList
    }
}