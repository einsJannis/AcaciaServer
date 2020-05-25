package dev.acaica.server.command.argument.type

interface CommandArgumentTypeCompanion<T : CommandArgumentType> {
    fun fromString(string: String): T
}