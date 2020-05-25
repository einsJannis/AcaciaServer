package dev.acaica.server.command.argument

import dev.acaica.server.command.argument.type.CommandArgumentType
import dev.acaica.server.command.argument.type.CommandArgumentTypeCompanion
import kotlin.reflect.KClass
import kotlin.reflect.full.companionObjectInstance

data class CommandArgument<T: CommandArgumentType>(
        val name: String,
        val type: KClass<T>,
        val optional: Boolean = false
) {
    fun parse(arg: String): T {
        return (type.companionObjectInstance as CommandArgumentTypeCompanion<T>).fromString(arg)
    }
}