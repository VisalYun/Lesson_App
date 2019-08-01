package com.learnprogramming.checkedbox_radiobtn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var orders:String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        select.setOnClickListener{
            var selectedId = group.checkedRadioButtonId
            when(selectedId){
                R.id.m -> {
                    Toast.makeText(this,"Male",Toast.LENGTH_LONG).show()
                }
                R.id.f -> {
                    Toast.makeText(this,"Female",Toast.LENGTH_LONG).show()
                }
            }
        }
        checked.setOnClickListener {
            orders = "Your orders: \n"
            if(pizza.isChecked){
                orders+="Pizza\n"
            }
            if(burger.isChecked){
                orders+="Burger\n"
            }
            tv.text = orders
        }
    }
}
