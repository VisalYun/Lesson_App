package com.learnprogramming.service_app

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var t:Time? = null
    var a:Ascii? = null
    var s1c = object : ServiceConnection{
        override fun onServiceDisconnected(p0: ComponentName?) {}
        override fun onServiceConnected(p0: ComponentName?, p1: IBinder?) {
            var time:Time.timeBinder = p1 as Time.timeBinder
            t = time.getTimeBinder()
        }
    }
    var s2c = object : ServiceConnection{
        override fun onServiceDisconnected(p0: ComponentName?) {}
        override fun onServiceConnected(p0: ComponentName?, p1: IBinder?) {
            var acsii:Ascii.acsiiBinder = p1 as Ascii.acsiiBinder
            a = acsii.getAcsiiBinder()
        }

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        time.isEnabled= false
        submit.isEnabled = false
    }

    var txt = ""
    fun service(v:View){
        var i1 = Intent(this,Time::class.java)
        var i2 = Intent(this,Ascii::class.java)
        when(v.id){
            R.id.startS1 -> {
                time.isEnabled = true
                startService(i1)
                bindService(i1,s1c,0)
            }
            R.id.stopS1 -> {
                time.isEnabled = false
                stopService(i1)
                textView.text = ""
            }
            R.id.startS2 -> {
                submit.isEnabled = true
                i2.putExtra("txt",inp.text.toString())
                startService(i2)
                bindService(i2,s2c, Context.BIND_AUTO_CREATE)
            }
            R.id.stopS2 -> {
                stopService(i2)
                submit.isEnabled = false
                res.text=""
            }
            R.id.time -> {
                textView.text = t?.getTime()
            }
            R.id.submit -> {
                res.text = a?.convert()
            }
        }
    }

}
