package com.greenspand.kotlin_ext

import android.net.wifi.WifiConfiguration


inline fun wifiConfiguration( func : WifiConfiguration.() -> Unit): WifiConfiguration{
    val config = WifiConfiguration()
    config.func()
    return config.apply(func)
}