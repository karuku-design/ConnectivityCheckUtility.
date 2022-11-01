package com.example.connectivitychange

import android.content.Context
import android.net.ConnectivityManager


class Networkstatus {

    var TYPE_NOT_CONNECTED = 0
    var TYPE_WIFI = 1
    var TYPE_MOBILE = 2

    fun getConnectivityStatus(context: Context?): Int {
        val cm = context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = cm.activeNetworkInfo
        if (null != activeNetwork) {
            if (activeNetwork.type == ConnectivityManager.TYPE_WIFI) return TYPE_WIFI
            if (activeNetwork.type == ConnectivityManager.TYPE_MOBILE) return TYPE_MOBILE
        }
        return TYPE_NOT_CONNECTED
    }

    fun getConnectivityStatusString(context: Context?): String? {

        val connStatus: Int = getConnectivityStatus(context)
        var status: String? = null

        if (connStatus == TYPE_WIFI) {
            status = "Wifi enabled"
        } else if (connStatus == TYPE_MOBILE) {
            status = "Mobile data enabled"
        } else if (connStatus == TYPE_NOT_CONNECTED) {
            status = "Not connected to Internet.Enable Wifi or data."
        }
        return status
    }


}