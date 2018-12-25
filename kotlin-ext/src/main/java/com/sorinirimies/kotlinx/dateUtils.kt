@file:JvmName("DateUtils")

package com.sorinirimies.kotlinx

import android.annotation.SuppressLint
import android.support.annotation.Keep
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

@SuppressLint("ConstantLocale")

private val SIMPLE_DATE_FORMAT = SimpleDateFormat("HH:mm", Locale.getDefault())

@Keep
fun formatDate(date: Date): String {
    return SIMPLE_DATE_FORMAT.format(date)
}

/**
 * Returns the total amount of minutes between two given times
 * @param start date
 * @param end date
 */
@Keep
fun minutesBetweenDates(start: Date, end: Date): Int {
    var duration: Long = 0
    duration += end.time - start.time

    return TimeUnit.MILLISECONDS.toMinutes(duration).toInt()
}

/**
 * Adds some additional minutes to the given date
 * @param minutes to be added
 * @param beforeTime the initial date
 */
@Keep
fun addMinutesToDate(minutes: Int, beforeTime: Date): Date {
    val oneMinuteInMillis: Long = 60000
    val curTimeInMs = beforeTime.time
    return Date(curTimeInMs + minutes * oneMinuteInMillis)
}

/** Formats in string minutes a given start and endTime Date
 * @param startTime
 * @param endTime
 * @return a minutes formatted string
 */
@Keep
fun formatInMinutes(startTime: Date, endTime: Date): String {
    return String.format(Locale.getDefault(), "%s min",
            minutesBetweenDates(startTime, endTime))
}

