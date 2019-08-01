package com.learnprogramming.popup_menu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.PopupMenu
import android.widget.SeekBar
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showPopup.setOnClickListener{
            var popupMenu = PopupMenu(this,it)
            popupMenu.inflate(R.menu.my_menu)
            popupMenu.show()

            popupMenu.setOnMenuItemClickListener {
                when(it.itemId){
                    R.id.op1 -> {
                        Toast.makeText(this,"Option 1",Toast.LENGTH_LONG).show()
                        true
                    }
                    R.id.op2 -> {
                        Toast.makeText(this,"Option 2",Toast.LENGTH_LONG).show()
                        true
                    }
                    R.id.op3 -> {
                        Toast.makeText(this,"Option 3",Toast.LENGTH_LONG).show()
                        true
                    }
                    else -> {
                        false
                    }
                }
            }
        }

        seekBar.max = 100
        //seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener())
    }
}
