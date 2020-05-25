package dev.acaica.server.types

import dev.einsjannis.math.vector.Vector3D

class Position(var x: Double, var y: Double, var z: Double) {
    var blockX: Int
        get() = x.toInt()
        set(value) { x = value.toDouble() + 0.5 }
    var blockY: Int
        get() = y.toInt()
        set(value) { y = value.toDouble() + 0.5 }
    var blockZ: Int
        get() = z.toInt()
        set(value) { z = value.toDouble() + 0.5 }

    fun toVector() = Vector3D(x, y, z)
}

fun Vector3D.toPosition() = Position(x, y, z)
