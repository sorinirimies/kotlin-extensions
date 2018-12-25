@file:JvmName("LogUtils")

package com.sorinirimies.kotlinx

import android.content.Context
import android.support.annotation.Keep
import android.util.Log

@Keep
fun Context.d(message: String) = Log.d(this.packageName, message)

@Keep
fun Context.i(message: String) = Log.i(this.packageName, message)

@Keep
fun Context.e(message: String) = Log.e(this.packageName, message)

@Keep
fun Context.w(message: String) = Log.w(this.packageName, message)

@Keep
fun Context.wtf(message: String) = Log.wtf(this.packageName, message)
