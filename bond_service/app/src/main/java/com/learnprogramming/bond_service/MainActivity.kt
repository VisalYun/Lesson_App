package com.learnprogramming.bond_service

import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var s:MyService? = null
    var sc = object: ServiceConnection{
        override fun onServiceDisconnected(p0: ComponentName?) {

        }

        override fun onServiceConnected(p0: ComponentName?, p1: IBinder?) {
            var b:MyService.binder = p1 as MyService.binder
            s = b.getServiceObj()
        }

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var i = Intent(this,MyService::class.java)
        bindService(i,sc,0)
        startService(i)
    }

    fun getC(v:View){
        tv.text = s?.getCoffee()
    }
}
