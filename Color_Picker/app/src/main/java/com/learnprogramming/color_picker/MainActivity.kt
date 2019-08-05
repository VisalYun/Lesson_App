package com.learnprogramming.color_picker

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var r = 0
        var g =0
        var b = 0
        var a = 0
        alpha.max = 255
        red.max = 255
        green.max = 255
        blue.max = 255

        class InnerClass: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                when(p0?.id){
                    R.id.alpha -> {
                        a = p1
                    }
                    R.id.red -> {
                        r=p1
                    }
                    R.id.green -> {
                        g = p1
                    }
                    R.id.blue -> {
                        b = p1
                    }
                }
                var color = Color.argb(a,r,g,b)
                background.setBackgroundColor(color)
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }
        }

        var listener = InnerClass()
        alpha.setOnSeekBarChangeListener(listener)
        red.setOnSeekBarChangeListener(listener)
        green.setOnSeekBarChangeListener(listener)
        blue.setOnSeekBarChangeListener(listener)
    }
}
