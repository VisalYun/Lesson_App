package com.learnprogramming.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun next(v:View){
        var intent =  Intent(this,second::class.java)
//        intent.putExtra("user_name","Visal")
//        intent.putExtra("School","KIT")
//        startActivity(intent)


        var bundle = Bundle()
        bundle.putString("user_name","Visal")
        bundle.putString("school","KIT")

        intent.putExtras(bundle)
        startActivity(intent)
    }
}
