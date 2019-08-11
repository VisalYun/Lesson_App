package com.learnprogramming.service

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder

class MyService: Service() {

    var mp:MediaPlayer? = null
    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        mp= MediaPlayer.create(this,R.raw.allfalldown)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        mp?.start()
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
        mp?.stop()
    }

}