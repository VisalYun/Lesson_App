package com.learnprogramming.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_second.*

class second : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

//        var name:String? = intent.getStringExtra("user_name")
//        var sch:String? = intent.getStringExtra("School")
//
//        user.text = "Welcome $name"
//        school.text = "Student of $sch"

        var bundle = intent.extras
        var name = bundle?.get("user_name")
        var sch = bundle?.get("school")

        user.text = "Welcome $name"
        school.text = "Student of $sch"
    }

}
