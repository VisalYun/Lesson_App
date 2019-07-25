package com.learnprogramming.implicit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun share(v:View){
        var i = Intent()
        i.action = Intent.ACTION_SEND
        var msg = message.text.toString()
        i.putExtra(Intent.EXTRA_TEXT,msg)
        i.type = "text/plain"
        startActivity(Intent.createChooser(i,"Share to"))
    }
}
