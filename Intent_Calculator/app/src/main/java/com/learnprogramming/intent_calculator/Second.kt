package com.learnprogramming.intent_calculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_second.*

class Second : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        var n1 = intent.getStringExtra("num1")
        var n2 = intent.getStringExtra("num2")
        v1.text = "Value 1: $n1"
        v2.text = "Value 1: $n2"
    }
    fun cal(v:View){
        var i = Intent()
        var n1 = intent.getStringExtra("num1")
        var n2 = intent.getStringExtra("num2")
        val btn = v as Button
        when(btn.id){
            R.id.plus -> {
                var ans = n1.toInt() + n2.toInt()
                i.putExtra("Data",ans.toString())
                setResult(1,i)
                finish()
            }
            R.id.sub -> {
                var ans = n1.toInt() - n2.toInt()
                i.putExtra("Data",ans.toString())
                setResult(1,i)
                finish()
            }
            R.id.mul -> {
                var ans = n1.toInt() * n2.toInt()
                i.putExtra("Data",ans.toString())
                setResult(1,i)
                finish()
            }
            R.id.div -> {
                if (n2.toInt()==0){
                    var ans = "Error"
                    i.putExtra("Data",ans)
                    setResult(1,i)
                    finish()
                }
                else {
                    var ans = n1.toInt() / n2.toInt()
                    i.putExtra("Data", ans.toString())
                    setResult(1, i)
                    finish()
                }
            }
        }
    }
}
