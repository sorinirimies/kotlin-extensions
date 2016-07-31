package com.greenspand.kotlin_ext

/**
 * Created by sorin on 4/18/16.
 */

/**Swaps list items
 *
 */
fun <T> MutableList<T>.swap(index1: Int, index2: Int) {
    val tmp = this[index1] // 'this' corresponds to the list
    this[index1] = this[index2]
    this[index2] = tmp
}