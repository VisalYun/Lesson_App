package com.learnprogramming.service_app

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.Build
import android.os.IBinder
import androidx.annotation.RequiresApi
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*
import java.util.logging.SimpleFormatter

class Time : Service() {

    lateinit var time:Date
    fun getTime():String{
        time = Date()
        val formatter = SimpleDateFormat("MMM dd yyyy HH:mm:ssa")
        val dt: String = formatter.format(time)
        return dt
    }

    inner class timeBinder:Binder() {
        fun getTimeBinder():Time{
            return this@Time
        }
    }
    var t = timeBinder()
    override fun onBind(intent: Intent): IBinder {
        return t
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onDestroy() {
        super.onDestroy()
        time.toInstant()
    }


}
