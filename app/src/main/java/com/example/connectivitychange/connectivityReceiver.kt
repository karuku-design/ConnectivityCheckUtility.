package com.example.connectivitychange

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class connectivityReceiver : BroadcastReceiver() {


    override fun onReceive(context: Context?, intent: Intent?) {

        var status: String? = Networkstatus().getConnectivityStatusString(context)

        Toast.makeText(context, status, Toast.LENGTH_LONG).show()
    }
}