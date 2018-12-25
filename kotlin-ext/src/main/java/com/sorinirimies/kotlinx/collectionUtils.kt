@file:JvmName("CollectionUtils")

package com.sorinirimies.kotlinx

import android.support.annotation.Keep
import java.util.*

@Keep
fun <K, V : Any> MutableMap<K, V>.toVarargArray(): Array<out Pair<K, V>> =
        map { Pair(it.key, it.value) }.toTypedArray()

@Keep
inline fun <T, R : Any> Iterable<T>.firstResult(predicate: (T) -> R?): R {
    for (element in this) {
        val result = predicate(element)
        if (result != null) return result
    }
    throw NoSuchElementException("No element matching predicate was found.")
}

/**Swaps list items
 * @param index1 first item
 * @param index2 second item
 */
@Keep
fun <T> MutableList<T>.swap(index1: Int, index2: Int) {
    val tmp = this[index1] // 'this' corresponds to the list
    this[index1] = this[index2]
    this[index2] = tmp
}

@Keep
inline fun <T, R> List<T>.map(transform: (T) -> R): List<R> {
    val result = arrayListOf<R>()
    for (item in this)
        result.add(transform(item))
    return result
}