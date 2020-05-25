package dev.acaica.server.types

class Identifier(var namespace: String, val id: String) {
    override fun toString(): String {
        return "$namespace:$id"
    }
    companion object {
        fun fromString(string: String): Identifier {
            val parts = string.split(":")
            return Identifier(parts[0], parts[1])
        }
    }
}