package dev.acaica.server

class JSONChat(
        val text: String,
        val bold: Boolean = false,
        val italic: Boolean = false,
        val underlined: Boolean = false,
        val strikethrough: Boolean = false,
        val color: String = "white",
        val insertion: String? = null,
        val clickEvent: JSONChatEvent? = null,
        val hoverEvent: JSONChatEvent? = null,
        val extra: List<JSONChat>? = null
) {
    fun toMap(): Map<String, Any> {
        TODO()
    }
}
class JSONChatEvent (
        val action: String,
        val value: String
)