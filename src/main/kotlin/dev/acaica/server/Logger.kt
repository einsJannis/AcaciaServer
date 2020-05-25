package dev.acaica.server

import java.io.OutputStream
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.*

object Logger {
    val streams: MutableMap<OutputStream, LogLevel> = mutableMapOf()
    fun timestamp() = DateTimeFormatter.ofPattern("yyyy/MM/dd-HH:mm:ss.SSS").withLocale(Locale.getDefault()).withZone(ZoneId.systemDefault()).format(Instant.now())
    fun log(message: String, logLevel: LogLevel) {
        streams.forEach {
            if (logLevel.ordinal <= it.value.ordinal)
                it.key.write("[${timestamp()}][${logLevel.name}] $message\n".toByteArray(charset("UTF-8")))
        }
    }
    fun error(message: String) = log(message, LogLevel.ERROR)
    fun warn(message: String) = log(message, LogLevel.WARNING)
    fun info(message: String) = log(message, LogLevel.INFORMATION)
    fun debug(message: String) = log(message, LogLevel.DEBUGGING)
    enum class LogLevel {
        ERROR, WARNING, INFORMATION, DEBUGGING
    }
}