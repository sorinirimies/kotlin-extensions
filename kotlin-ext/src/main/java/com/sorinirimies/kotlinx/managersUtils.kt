@file:JvmName("ManagerUtils")

package com.sorinirimies.kotlinx

import android.net.wifi.WifiConfiguration

inline fun wifiConfiguration(func: WifiConfiguration.() -> Unit): WifiConfiguration {
    val config = WifiConfiguration()
    config.func()
    return config.apply(func)
}