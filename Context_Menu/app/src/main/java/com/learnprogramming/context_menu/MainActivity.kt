package com.learnprogramming.context_menu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        registerForContextMenu(tv)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.pho -> {
                Toast.makeText(this,"Pho",Toast.LENGTH_LONG).show()
                return true
            }
            R.id.banh_mi -> {
                Toast.makeText(this,"Banh Mi",Toast.LENGTH_LONG).show()
                return true
            }
            R.id.banh_xeo -> {
                Toast.makeText(this,"Banh Xeo",Toast.LENGTH_LONG).show()
                return true
            }
            else -> {
                return false
            }
        }
        return super.onContextItemSelected(item)
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.my_menu,menu)
    }
}
