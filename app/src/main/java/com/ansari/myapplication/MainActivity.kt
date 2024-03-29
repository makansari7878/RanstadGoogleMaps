package com.ansari.myapplication

import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var filter = IntentFilter("android.intent.action.AIRPLANE_MODE")
        var myReceiver = MyReceiver()
        registerReceiver(myReceiver, filter )

    }
}