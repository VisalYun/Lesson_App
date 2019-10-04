package com.learnprogramming.database

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun insert(v:View){
        var city = txtCity.text.toString()
        var name = txtName.text.toString()

        var dto = Staff(city, name)

        var helper = DBHelper(this)
        var res = helper.insertData(dto)

        if (res == -1.toLong()){
            Toast.makeText(this, "fail", Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(this, "suc*", Toast.LENGTH_LONG).show()
        }
    }

    fun viewData(v:View){
        var db = DBHelper(this)
        var arrlist = db.readRecord()
        var str = ""
        for(i in arrlist){
            str += "${i.city} : ${i.sname} \n"
        }
        tv.text = str
    }
}
