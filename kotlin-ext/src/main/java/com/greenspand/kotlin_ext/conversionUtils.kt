@file:JvmName("ConversionUtils")


package com.greenspand.kotlin_ext

import android.util.Base64
import java.math.BigInteger
import java.nio.ByteBuffer
import java.nio.ByteOrder
import java.nio.charset.Charset

/**
 * Created by sorin on 14.10.15.
 */

/**
 * Returns the integer value converted from a byte array

 * @param b
 * *
 * @return
 */
 fun returnIntFromByteArray(b: ByteArray): Int {
    val bb = ByteBuffer.wrap(b)
    bb.order(ByteOrder.LITTLE_ENDIAN)
    return bb.getInt()
}

 fun byteArrayFromInt(i: Int): ByteArray = BigInteger.valueOf(i.toLong()).toByteArray()


/**
 * One way of converting int into byte array

 * @param value
 * *
 * @return
 */
 fun intToByteArray(value: Int): ByteArray {
    var result = ByteArray(4)
    result[0] = (value shr 24).toByte()
    result[1] = (value shr 16).toByte()
    result[2] = (value shr 8).toByte()
    result[3] = (value shr 0).toByte()
    return result
}

 fun intToByte(input: IntArray): ByteArray {
    var output = ByteArray(input.size * 4)
    for (i in input.indices) {
        output[i * 4] = (input[i] and 255).toByte()
        output[i * 4 + 1] = ((input[i] and 65280).ushr(8)).toByte()
        output[i * 4 + 2] = ((input[i] and 16711680).ushr(16)).toByte()
        output[i * 4 + 3] = ((input[i] and -16777216).ushr(24)).toByte()
    }
    return output
}

/**
 * One way of converting int into byte array

 * @param value
 * *
 * @return
 */
 fun convertIntToByteArray(value: Int): ByteArray = BigInteger.valueOf(value.toLong()).toByteArray()


 fun concatenateByteArray(payload: ByteArray, value: Int): ByteArray {
    var intVal = intToByteArray(value)
    val combined = ByteArray(payload.size + intVal.size)
    for (i in combined.indices) {
        combined[i] = if (i < payload.size) payload[i] else intVal[i - intVal.size]
    }
    return combined
}


/**
 * Returns the bytearray of a string, in format UTF-8

 * @param str
 * *
 * @return
 */
 fun returnByteArrayFromString(str: String, formatUTF: Boolean): ByteArray {
    val bArray: ByteArray
    if (formatUTF) {
        bArray = str.toByteArray(Charset.forName("UTF-8"))
    } else {
        bArray = str.toByteArray()
    }
    return bArray
}

 fun returnByteArrayFromDouble(d: Double): ByteArray {
    val b = ByteArray(8)
    ByteBuffer.wrap(b).putDouble(d)
    return b
}

/**
 * Max 255
 * Converts an integer to a byte. Max value is 255

 * @return
 */
 fun returnByteFromInteger(i: Int): Byte {
    val b = (i and 255).toByte()
    return b
}


/**
 * Return the double from the byte array

 * @param b
 * *
 * @return
 */
 fun doubleFromByteArray(b: ByteArray): Double = ByteBuffer.wrap(b).double



/**Decodes encoded Base 64 Chars*/
 fun base64Decode(s: String): ByteArray = Base64.decode(s, Base64.DEFAULT)

 fun base64Encode(b: ByteArray): String = Base64.encodeToString(b, Base64.DEFAULT).trim()
