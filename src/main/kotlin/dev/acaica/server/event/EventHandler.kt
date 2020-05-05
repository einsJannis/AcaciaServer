package dev.acaica.server.event

import kotlin.reflect.KType
import kotlin.reflect.full.createType
import kotlin.reflect.full.memberFunctions

object EventHandler {
    fun callEvent(event: Event) {
        EventListener::class.sealedSubclasses.forEach { kClass ->
            kClass.memberFunctions.filter {
                it.parameters.size == 1 && it.parameters[0].type == typeOfEvent(event)
            }.forEach {
                it.call(event)
            }
        }
    }
    fun typeOfEvent(event: Event): KType {
        val kType = Event::class.sealedSubclasses.find { it.isInstance(event) }?.createType()
        return kType ?: throw RuntimeException()
    }
}