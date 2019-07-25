package com.learnprogramming.app_life_cycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Toast.makeText(this,"Application Created",Toast.LENGTH_LONG)
        Log.d("lifecycle","onCreate Invokes")
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        Log.d("lifecycle","onStart Invokes")
    }

    override fun onResume() {
        super.onResume()
        Log.d("lifecycle","onResume Invokes")
    }

    override fun onPause() {
        super.onPause()
        Log.d("lifecycle","onPause Invokes")
    }

    override fun onStop() {
        super.onStop()
        Log.d("lifecycle","onStop Invokes")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("lifecycle","onDestroy Invokes")
    }
}
