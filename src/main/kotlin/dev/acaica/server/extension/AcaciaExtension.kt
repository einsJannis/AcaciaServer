package dev.acaica.server.extension

import dev.acaica.server.acacia.DefaultExtension

interface AcaciaExtension {
    fun onLoad()
    fun onStart()
    fun onStop()
    companion object {
        fun loadExtensions() {
            getExtensions().forEach { it.onLoad() }
        }
        fun startExtensions() {
            getExtensions().forEach { it.onStart() }
        }
        fun stopExtensions() {
            getExtensions().forEach { it.onStop() }
        }
        fun getExtensions(): List<AcaciaExtension> {
            return listOf(DefaultExtension)
        }
    }
}
