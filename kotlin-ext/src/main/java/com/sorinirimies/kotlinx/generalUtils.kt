@file:JvmName("GeneralUtils")

package com.sorinirimies.kotlinx

import android.support.annotation.Keep

/**
 * Null check for multiple objects at a time.
 * @param block a list of nullable objects
 */
@Keep
inline fun <T : Any, R : Any> Collection<T?>.whenAllNotNull(block: (List<T>) -> R) {
    if (this.all { it != null }) {
        block(this.filterNotNull())
    }
}

/**
 * Null check for at least one object at a time.
 * @param block a list of nullable objects
 */
@Keep
inline fun <T : Any, R : Any> Collection<T?>.whenAnyNotNull(block: (List<T>) -> R) {
    if (this.any { it != null }) {
        block(this.filterNotNull())
    }
}