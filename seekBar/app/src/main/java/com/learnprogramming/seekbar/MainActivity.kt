package com.learnprogramming.seekbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        seekBar.max = 200
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                tv.text = "Current: $p1"
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
                tv.text = "Seekbar touched"

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                tv.text = "Final value: ${seekBar.progress}"
            }
        })
    }
}
