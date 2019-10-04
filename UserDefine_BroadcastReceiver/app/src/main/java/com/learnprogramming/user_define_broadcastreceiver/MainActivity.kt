package com.learnprogramming.user_define_broadcastreceiver

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun sendBroadcast(v:View){
        var i = Intent(this,MyReceiver::class.java) //for api 26 and above
        //var i = Intent(MyReceiver) //for api 25 and under
        sendBroadcast(i)
    }
}
