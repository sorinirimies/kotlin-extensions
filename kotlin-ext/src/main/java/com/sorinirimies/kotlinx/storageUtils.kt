@file:JvmName("StorageUtils")

package com.sorinirimies.kotlinx

import android.content.SharedPreferences
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.support.annotation.Keep

/**
 * Database cursor iterator.
 * @param columnName
 */
@Keep
fun Cursor.getStringOrNull(columnName: String): String? {
    val index = getColumnIndexOrThrow(columnName)
    return if (isNull(index)) null else getString(index)
}

/**
 * SQLite transaction extension function expression.
 */
@Keep
inline fun SQLiteDatabase.transaction(body: SQLiteDatabase.() -> Unit) {
    beginTransaction()
    try {
        body()
        setTransactionSuccessful()
    } finally {
        endTransaction()
    }
}

/**
 * Extension function expression for editing preferences.
 */
@Keep
inline fun SharedPreferences.editPrefs(func: SharedPreferences.Editor.() -> Unit) {
    val editor = edit()
    editor.func()
    editor.apply()
}

@Keep
fun SharedPreferences.Editor.setStringSet(pair: Pair<String, Set<String>>) = putStringSet(pair.first, pair.second)

@Keep
fun SharedPreferences.Editor.setString(pair: Pair<String, String>) = putString(pair.first, pair.second)

@Keep
fun SharedPreferences.Editor.setInt(pair: Pair<String, Int>) = putInt(pair.first, pair.second)

@Keep
fun SharedPreferences.Editor.setBoolean(pair: Pair<String, Boolean>) = putBoolean(pair.first, pair.second)

@Keep
fun SharedPreferences.Editor.setFloat(pair: Pair<String, Float>) = putFloat(pair.first, pair.second)

@Keep
fun SharedPreferences.Editor.setLong(pair: Pair<String, Long>) = putLong(pair.first, pair.second)