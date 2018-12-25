@file:JvmName("GeneralUtils")

/* ktlint-disable no-wildcard-imports */

package com.greenspand.kotlinx

/** Null check for multiple objects at a time*/
inline fun <T : Any, R : Any> Collection<T?>.whenAllNotNull(block: (List<T>) -> R) {
    if (this.all { it != null }) {
        block(this.filterNotNull())
    }
}

/** Null check for at least one object at a time*/
inline fun <T : Any, R : Any> Collection<T?>.whenAnyNotNull(block: (List<T>) -> R) {
    if (this.any { it != null }) {
        block(this.filterNotNull())
    }
}