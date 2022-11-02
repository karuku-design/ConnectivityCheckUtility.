package com.example.connectivitychange

import android.content.IntentFilter
import android.net.wifi.WifiManager
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val receiver = connectivityReceiver()
        val networkStatus: String? = receiver.status

        val filter = IntentFilter(WifiManager.SUPPLICANT_STATE_CHANGED_ACTION)
        this.registerReceiver(connectivityReceiver(), filter)
        Toast.makeText(applicationContext, networkStatus, Toast.LENGTH_LONG).show()


    }
    override fun onResume() {
        super.onResume()
        val filter = IntentFilter(WifiManager.SUPPLICANT_STATE_CHANGED_ACTION)
        this.registerReceiver(connectivityReceiver(), filter)
    }

    override fun onPause() {
        unregisterReceiver(connectivityReceiver())
        super.onPause()
    }
}