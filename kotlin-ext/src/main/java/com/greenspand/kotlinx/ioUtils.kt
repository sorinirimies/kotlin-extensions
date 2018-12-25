@file:JvmName("IOUtils")
/* ktlint-disable no-wildcard-imports */

package com.greenspand.kotlinx

import android.content.res.AssetManager
import java.nio.charset.Charset

/**
 * Created by mihai on 7/2/2017.
 */
/**
 * Extension function for converting a file from the assets folder into a string output
 * @param subdirectory if provided as a string description
 * @param filename given
 */
fun AssetManager.fileAsString(subdirectory: String, filename: String): String {
    return open("$subdirectory/$filename").use {
        it.readBytes().toString(Charset.defaultCharset())
    }
}