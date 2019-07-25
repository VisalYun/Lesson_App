package com.learnprogramming.intent_calculator

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
    fun next(v:View){
        var i = Intent(this,Second::class.java)
        var n1 = num1.text.toString()
        var n2 = num2.text.toString()
        i.putExtra("num1",n1)
        i.putExtra("num2",n2)
        startActivityForResult(i,1)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==1){
            var answer = data?.getStringExtra("Data")
            ans.text = "Answer: $answer"
        }
    }
}
