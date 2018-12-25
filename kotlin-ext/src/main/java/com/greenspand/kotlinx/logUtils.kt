@file:JvmName("LogUtils")
/* ktlint-disable no-wildcard-imports */

package com.greenspand.kotlinx

import android.content.Context
import android.util.Log

fun Context.d(message: String) = Log.d(this.packageName, message)

fun Context.i(message: String) = Log.i(this.packageName, message)

fun Context.e(message: String) = Log.e(this.packageName, message)

fun Context.w(message: String) = Log.w(this.packageName, message)

fun Context.wtf(message: String) = Log.wtf(this.packageName, message)
