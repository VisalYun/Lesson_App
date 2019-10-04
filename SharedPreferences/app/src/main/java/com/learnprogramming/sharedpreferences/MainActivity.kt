package com.learnprogramming.sharedpreferences

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var pref=MyPre(this@MainActivity)

        var currentScore=pref.getScore()
        count.text="Your score is $currentScore"

        currentScore++

        pref.setScore(currentScore)
    }
}
