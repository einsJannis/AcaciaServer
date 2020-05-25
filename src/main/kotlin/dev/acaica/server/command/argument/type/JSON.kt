package dev.acaica.server.command.argument.type

import com.google.gson.Gson
import dev.acaica.server.JSONChat

class JSON(val string: String) : CommandArgumentType {
    fun toJSONChat(): JSONChat = Gson().fromJson(string, JSONChat::class.java)
    companion object : CommandArgumentTypeCompanion<JSON> {
        override fun fromString(string: String): JSON = JSON(string)
    }
}