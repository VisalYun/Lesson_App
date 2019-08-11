package com.learnprogramming.service

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun music(v:View){
        var i = Intent(this,MyService::class.java)
        when(v.id){
            R.id.start -> {
                startService(i)
            }
            R.id.stop -> {
                stopService(i)
            }
        }
    }
}
