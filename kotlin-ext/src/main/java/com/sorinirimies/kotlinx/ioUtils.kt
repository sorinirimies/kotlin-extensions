@file:JvmName("IOUtils")

package com.sorinirimies.kotlinx

import android.content.res.AssetManager
import java.nio.charset.Charset

/**
 * Extension function for converting a file from the assets folder into a string output.
 * @param subdirectory if provided as a string description
 * @param filename
 * @return a stringified file
 */
fun AssetManager.fileAsString(subdirectory: String, filename: String): String {
    return open("$subdirectory/$filename").use {
        it.readBytes().toString(Charset.defaultCharset())
    }
}