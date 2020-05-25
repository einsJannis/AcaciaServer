package dev.einsjannis.math.vector

import kotlin.math.abs
import kotlin.math.acos
import kotlin.math.pow
import kotlin.math.sqrt

class Vector3D(val x: Double, val y: Double, val z: Double) {

    operator fun plus(vector3D: Vector3D): Vector3D = Vector3D(x + vector3D.x, y + vector3D.y, z + vector3D.z)

    operator fun minus(vector3D: Vector3D): Vector3D = Vector3D(x - vector3D.x, y - vector3D.y, z + vector3D.z)

    operator fun times(vector3D: Vector3D): Double = x * vector3D.x + y * vector3D.y + z * vector3D.z

    fun crossProduct(vector3D: Vector3D): Vector3D = Vector3D(
            y * vector3D.z - z * vector3D.y,
            z * vector3D.x - x * vector3D.z,
            x * vector3D.y - y * vector3D.x
    )

    operator fun times(double: Double): Vector3D {
        return Vector3D(x * double, y * double, z * double)
    }

    operator fun div(double: Double): Vector3D {
        return Vector3D(x / double, y / double, z / double)
    }

    val length
        get() = abs(sqrt(x.pow(2) + y.pow(2)))

    fun collinearTo(vector3D: Vector3D): Boolean = acos((this*vector3D)/(this.length*vector3D.length)) == 0.0

    fun perpendicularTo(vector3D: Vector3D): Boolean = this*vector3D == 0.0

}

operator fun Double.times(vector3D: Vector3D): Vector3D {
    return Vector3D(this * vector3D.x, this * vector3D.y, this * vector3D.z)
}

operator fun Double.div(vector3D: Vector3D): Vector3D {
    return Vector3D(this * vector3D.x, this * vector3D.y, this * vector3D.z)
}
