package com.learnprogramming.service_app

import android.annotation.SuppressLint
import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder

class Ascii : Service() {

    var txt:String? = null
    fun convert():String{
        var res = ""
        if (txt != null){
            for (i in txt!!){
                res+="$i - ${i.toInt()}\n"
            }
            return res
        }
        else{
            return "false"
        }
    }
    inner class acsiiBinder:Binder(){
        fun getAcsiiBinder():Ascii{
            return this@Ascii
        }
    }

    var ab = acsiiBinder()
    override fun onBind(intent: Intent): IBinder {
        //txt = intent.getStringExtra("txt")
        return ab
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        txt = intent?.getStringExtra("txt")
        return super.onStartCommand(intent, flags, startId)
    }
}
