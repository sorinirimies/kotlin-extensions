@file:JvmName("DateUtils")

package com.greenspand.kotlin_ext

import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

/**
 * Created by mihai on 7/2/2017.
 */

private val SIMPLE_DATE_FORMAT = SimpleDateFormat("HH:mm", Locale.getDefault())
private val MINUTES_OF_HOUR = 60

fun formatDate(date: Date): String {
    return SIMPLE_DATE_FORMAT.format(date)
}

/**
 * Returns the total amount of minutes between two given times
 * @param start date
 * @param end date
 */
fun minutesBetweenDates(start: Date, end: Date): Int {
    var duration: Long = 0
    duration += end.time - start.time

    return TimeUnit.MILLISECONDS.toMinutes(duration).toInt()
}


fun String.formatDate(): String {
    val initialFormat = SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss'Z'", Locale.ENGLISH)
    val format = SimpleDateFormat("yyyy-M-dd", Locale.US)
    val date = initialFormat.parse(this)
    return format.format(date).toString()
}

/**
 * Adds some additional minutes to the given date
 * @param minutes to be added
 * @param beforeTime the initial date
 */
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
fun formatInMinutes(startTime: Date, endTime: Date): String {
    return String.format(Locale.getDefault(), "%s min",
            minutesBetweenDates(startTime, endTime))
}
