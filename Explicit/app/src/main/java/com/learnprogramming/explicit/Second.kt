package com.learnprogramming.explicit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_second.*

class Second : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
    }
    fun goHome(v:View){
        var i = Intent()
        var str = editText.text.toString()

        i.putExtra("Data",str)
        setResult(1,i)
        finish()
    }
}
