package com.ansari.myapplication

import android.content.IntentFilter
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ansari.myapplication.databinding.ActivityMainBinding

import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.google.firebase.messaging.FirebaseMessaging




class MainActivity : AppCompatActivity() {
    lateinit var mainViewModel : MainViewModel

    val realtimeDatabase = Firebase.database
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setContentView(R.layout.activity_main)

        var mainXml = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainXml.root)

       /* var clickButton = findViewById<Button>(R.id.buttonClick)
        var counterTextView = findViewById<TextView>(R.id.textViewCounter)*/
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        mainViewModel.myLiveData.observe(this, {
            mainXml.textViewCounter.text = it
        })


       mainXml.buttonClick.setOnClickListener {
//                mainViewModel.increment()
//            counterTextView.text = mainViewModel.count.toString()

           // mainViewModel.dataChange()


           // Retrieving the FCM token
           FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener { task ->
               if (!task.isSuccessful) {
                   mainXml.textViewCounter.text = "Fetching FCM registration token failed"
                   return@OnCompleteListener
               }

               // fetching the token
               val token = task.result

               mainXml.textViewCounter.text = "Token saved successfully!"

               // directory reference
               val tokenDirRef = realtimeDatabase.getReference("Tokens")

               // storing the value
               tokenDirRef.setValue(token.toString())

               // toast to show  message
               Toast.makeText(
                   baseContext,
                   "Firebase Generated Successfully and saved to realtime database $token",
                   Toast.LENGTH_LONG
               ).show()

               Log.i("mytag", "$token")
           })
        }








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