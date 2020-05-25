package dev.acaica.server

fun Int.toByteArray(): ByteArray {
    val byteArray = ByteArray(4)
    var num = this
    for (i in byteArray.indices) {
        byteArray[i] = num.and(0xFF).toByte()
        num = num.shr(8)
    }
    byteArray.reverse()
    return byteArray
}

operator fun Boolean.inc() = !this
operator fun Boolean.dec() = !this
