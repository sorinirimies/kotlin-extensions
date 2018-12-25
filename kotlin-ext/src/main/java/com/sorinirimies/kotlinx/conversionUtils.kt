@file:JvmName("ConversionUtils")

package com.sorinirimies.kotlinx

import android.support.annotation.Keep
import android.util.Base64
import java.math.BigDecimal
import java.math.BigInteger
import java.nio.ByteBuffer
import java.nio.ByteOrder
import java.nio.charset.Charset

/**
 * Returns the integer value converted from a byte array
 * @param b
 * @return
 */
@Keep
fun ByteArray.toInt(): Int {
    val bb = ByteBuffer.wrap(this)
    bb.order(ByteOrder.LITTLE_ENDIAN)
    return bb.int
}

@Keep
fun Int.byteArrayFromInt(): ByteArray = BigInteger.valueOf(this.toLong()).toByteArray()

/**
 * One way of converting int into byte array
 * @return
 */
@Keep
fun Int.toByteArray(): ByteArray {
    val result = ByteArray(4)
    result[0] = (this shr 24).toByte()
    result[1] = (this shr 16).toByte()
    result[2] = (this shr 8).toByte()
    result[3] = (this shr 0).toByte()
    return result
}

@Keep
fun IntArray.toByteArray(): ByteArray {
    val output = ByteArray(this.size * 4)
    for (i in this.indices) {
        output[i * 4] = (this[i] and 255).toByte()
        output[i * 4 + 1] = ((this[i] and 65280).ushr(8)).toByte()
        output[i * 4 + 2] = ((this[i] and 16711680).ushr(16)).toByte()
        output[i * 4 + 3] = ((this[i] and -16777216).ushr(24)).toByte()
    }
    return output
}

/**
 * One way of converting int into byte array.
 * @param value
 * @return
 */
@Keep
fun convertIntToByteArray(value: Int): ByteArray = BigInteger.valueOf(value.toLong()).toByteArray()

@Keep
fun concatenateByteArray(payload: ByteArray, value: Int): ByteArray {
    val intVal: ByteArray = value.toByteArray()
    val combined = ByteArray(payload.size + intVal.size)
    for (i in combined.indices) {
        combined[i] = if (i < payload.size) payload[i] else intVal[i - intVal.size]
    }
    return combined
}

/**
 * Returns the bytearray of a string, in format UTF-8
 * @param str
 * @return
 */
@Keep
fun returnByteArrayFromString(str: String, formatUTF: Boolean): ByteArray {
    val bArray: ByteArray
    if (formatUTF) {
        bArray = str.toByteArray(Charset.forName("UTF-8"))
    } else {
        bArray = str.toByteArray()
    }
    return bArray
}

@Keep
fun returnByteArrayFromDouble(d: Double): ByteArray {
    val b = ByteArray(8)
    ByteBuffer.wrap(b).putDouble(d)
    return b
}

/**
 * Max 255
 * Converts an integer to a byte. Max value is 255
 * @return byte
 */
@Keep
fun returnByteFromInteger(i: Int): Byte {
    val b = (i and 255).toByte()
    return b
}

/**Number formatting */
@Keep
fun Double.toBigDecimal(): BigDecimal = BigDecimal.valueOf(this)

@Keep
operator fun BigDecimal.plus(a: BigDecimal): BigDecimal = this.add(a)

@Keep
operator fun BigDecimal.minus(a: BigDecimal): BigDecimal = this.subtract(a)

@Keep
operator fun BigDecimal.times(a: BigDecimal): BigDecimal = this.multiply(a)

@Keep
operator fun BigDecimal.div(a: BigDecimal): BigDecimal = this.divide(a)

/**
 * Return the double from the byte array.
 * @param b the given [ByteArray]
 * @return the double from the [ByteArray]
 */
@Keep
fun doubleFromByteArray(b: ByteArray): Double = ByteBuffer.wrap(b).double

/**Decodes encoded Base 64 Chars*/
@Keep
fun base64Decode(s: String): ByteArray = Base64.decode(s, Base64.DEFAULT)

@Keep
fun base64Encode(b: ByteArray): String = Base64.encodeToString(b, Base64.DEFAULT).trim()
