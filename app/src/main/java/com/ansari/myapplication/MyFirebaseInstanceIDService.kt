package com.ansari.myapplication

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseInstanceIDService : FirebaseMessagingService() {



    //Called when message is received and app is in foreground.
    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        // Check if message contains a data payload.
        remoteMessage.data.let {
            Log.d("mytag", "Message data payload: " + remoteMessage.data)
        }

        // Check if message contains a notification payload.
        remoteMessage.notification?.let {
            Log.d("mytag", "Message Notification Body: ${it.body}")
           // sendNotification(it.title!!, it.body!!, it.icon, it.imageUrl)
        }
    }

    override fun onNewToken(token: String) {
        Log.d("mytag", "Refreshed token: $token")
        //Send this token to server
    }



}