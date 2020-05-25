package dev.acaica.server

import com.google.gson.annotations.SerializedName

class JSONChat(
        @SerializedName("text") val text: String,
        @SerializedName("bold") val bold: Boolean = false,
        @SerializedName("italic") val italic: Boolean = false,
        @SerializedName("underlined") val underlined: Boolean = false,
        @SerializedName("strikethrough") val strikethrough: Boolean = false,
        @SerializedName("color") val color: String = "white",
        @SerializedName("insertion") val insertion: String? = null,
        @SerializedName("clickEvent") val clickEvent: JSONChatEvent? = null,
        @SerializedName("hoverEvent") val hoverEvent: JSONChatEvent? = null,
        @SerializedName("extra") val extra: List<JSONChat>? = null
)
class JSONChatEvent (
        val action: String,
        val value: String
) {
    fun toMap(): Map<String, String> = mapOf(
            "action" to action
    )
}