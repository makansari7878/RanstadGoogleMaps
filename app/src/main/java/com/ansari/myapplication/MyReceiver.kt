package com.ansari.myapplication

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.telephony.SmsMessage
import android.util.Log
import android.widget.Toast

class MyReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {

        // Retrieves a map of extended data from the intent.
        val bundle = intent?.extras
        try {
            if (bundle != null) {
                val pdusObj = bundle["pdus"] as Array<Any>?
                for (i in pdusObj!!.indices) {
                    val currentMessage = SmsMessage.createFromPdu(
                        pdusObj[i] as ByteArray
                    )
                    val phoneNumber = currentMessage.displayOriginatingAddress
                    val message = currentMessage.displayMessageBody

                    var arr = message.split(" ").toTypedArray()

                    var first = arr[0]
                    var second = arr[1]


                    Log.i("mytag","splitted $second and $first")
                    Log.i("mytag", "senderNum: $phoneNumber; message: $message")

                    // Show Alert
                    val toast = Toast.makeText(
                        context,
                        "senderNum: $phoneNumber, message: $message", Toast.LENGTH_LONG
                    )
                    toast.show()
                } // end for loop
            } // bundle is null
        } catch (e: Exception) {
            Log.e("mytag", "Exception smsReceiver$e")
        }
    }

}
