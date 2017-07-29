@file:JvmName("LocationUtils")

package com.greenspand.kotlin_ext

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
    try {
        val geocoder = Geocoder(this, Locale.getDefault())
        val addresses: List<Address>? = geocoder.getFromLocation(lat, lng, 1)
        return addresses
    } catch (e: Exception) {
        return null
    }
}