@file:JvmName("ManagerUtils")

package com.sorinirimies.kotlinx

import android.net.wifi.WifiConfiguration
import android.support.annotation.Keep

/**
 * Exposes the [WifiConfiguration] API.
 * @return an instance of the [WifiConfiguration] API.
 */
@Keep
inline fun wifiConfiguration(func: WifiConfiguration.() -> Unit): WifiConfiguration {
    val config = WifiConfiguration()
    config.func()
    return config.apply(func)
}