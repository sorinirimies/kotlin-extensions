@file:JvmName("LocationUtils")

package com.sorinirimies.kotlinx

import android.content.Context
import android.location.Address
import android.location.Geocoder
import java.util.*

/**
 * Created by mihai on 9/11/2016.
 */
/**
 * Gets a complete address from anywhere where there is a provided context
 */
fun Context.getStreetAddress(lat: Double, lng: Double): List<Address>? {
    return try {
        val geoCoder = Geocoder(this, Locale.getDefault())
        geoCoder.getFromLocation(lat, lng, 1)
    } catch (e: Exception) {
        null
    }
}