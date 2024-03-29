package com.ansari.myapplication

import android.content.IntentFilter
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var filter = IntentFilter("android.provider.Telephony.SMS_RECEIVED")
        var myReceiver = MyReceiver()
        registerReceiver(myReceiver, filter )

        if(ActivityCompat.checkSelfPermission(this,android.Manifest.permission.RECEIVE_SMS)== PackageManager.PERMISSION_GRANTED){
            Toast.makeText(this,"PERMISSION GRANTED",Toast.LENGTH_SHORT).show()
        }
        else
        {
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.RECEIVE_SMS),124)
        }


    }
}