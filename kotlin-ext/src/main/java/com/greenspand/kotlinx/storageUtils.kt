@file:JvmName("StorageUtils")

/* ktlint-disable no-wildcard-imports */

package com.greenspand.kotlinx

import android.content.SharedPreferences
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase

/**
 * Database cursor iterator
 */
fun Cursor.getStringOrNull(columnName: String): String? {
    val index = getColumnIndexOrThrow(columnName)
    return if (isNull(index)) null else getString(index)
}

/**
 * SQLite transaction extension function expression
 *
 */
inline fun SQLiteDatabase.transaction(body: SQLiteDatabase.() -> Unit) {
    beginTransaction()
    try {
        body()
        setTransactionSuccessful()
    } finally {
        endTransaction()
    }
}

fun Cursor.getString(columnName: String): String = getStringOrNull(columnName)!!

inline fun SharedPreferences.editPrefs(func: SharedPreferences.Editor.() -> Unit) {
    val editor = edit()
    editor.func()
    editor.apply()
}

fun SharedPreferences.Editor.setStringSet(pair: Pair<String, Set<String>>) = putStringSet(pair.first, pair.second)
fun SharedPreferences.Editor.setString(pair: Pair<String, String>) = putString(pair.first, pair.second)
fun SharedPreferences.Editor.setInt(pair: Pair<String, Int>) = putInt(pair.first, pair.second)
fun SharedPreferences.Editor.setBoolean(pair: Pair<String, Boolean>) = putBoolean(pair.first, pair.second)
fun SharedPreferences.Editor.setFloat(pair: Pair<String, Float>) = putFloat(pair.first, pair.second)
fun SharedPreferences.Editor.setLong(pair: Pair<String, Long>) = putLong(pair.first, pair.second)