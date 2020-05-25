package dev.acaica.server.command

class CommandSet private constructor() : HashMap<String, Command>() {
    class Builder internal constructor() {
        internal val commandSet = CommandSet()
        fun command(name: String, command: Command.Builder.() -> Unit) {
            val commandBuilder = Command.Builder()
            command(commandBuilder)
            commandSet.put(name, commandBuilder.command)
        }
    }
    companion object {
        val registeredCommandSets: MutableList<CommandSet> = mutableListOf()

        fun registerCommandSet(commandSet: CommandSet) {
            registeredCommandSets.add(commandSet)
        }

        fun emptyCommandSet(): CommandSet {
            return CommandSet()
        }
    }
}

fun commandSet(builder: CommandSet.Builder.() -> Unit): CommandSet {
    val setBuilder = CommandSet.Builder()
    builder(setBuilder)
    return setBuilder.commandSet
}
