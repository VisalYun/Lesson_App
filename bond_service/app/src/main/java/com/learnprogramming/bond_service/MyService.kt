package com.learnprogramming.bond_service

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder

class MyService : Service() {

    //service function
    fun getCoffee():String{
        return "Here is your coffee..."
    }
    //return the object of the service
    inner class binder:Binder(){
        fun getServiceObj():MyService{
            return this@MyService
        }
    }
    var b = binder()
    //execute when connect to service
    override fun onBind(intent: Intent): IBinder {
        return b
    }
}
