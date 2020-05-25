package dev.acaica.server.acacia

import dev.acaica.server.Logger
import dev.acaica.server.command.CommandSet
import dev.acaica.server.event.Event
import dev.acaica.server.event.PacketReceivedEvent
import dev.acaica.server.extension.AcaciaExtension

object DefaultExtension : AcaciaExtension {
    override fun onLoad() {
    }

    @ExperimentalUnsignedTypes
    override fun onStart() {
        Logger.info("DefaultExtension started")
        CommandSet.registerCommandSet(Commands.defaultCommands)
        CommandSet.registerCommandSet(Commands.moderationCommands)
    }

    override fun onStop() {

    }
}