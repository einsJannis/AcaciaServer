package dev.acaica.server.event

import kotlin.reflect.KClass

interface Event {
    companion object {
        private val handlers: MutableMap<KClass<*>, (Event) -> Unit> = mutableMapOf()
        fun <E : Event> registerListener(event: KClass<E>, handler: (E) -> Unit) {
            handlers[event] = handler as (Event) -> Unit
        }
        fun <E : Event> on(event: KClass<E>, handler: (E) -> Unit) = registerListener(event, handler)
        fun emit(event: Event) {
            handlers.filter { it.key == event::class }.forEach {
                it.value(event)
            }
        }
    }
}