package com.learnprogramming.tictactoe

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun play(view:View){
        var winner = 0
        reset.isEnabled = false
        val btn = view as Button
        var cellid = 0
        when(btn.id){
            R.id.btn00 -> cellid = 1
            R.id.btn01 -> cellid = 2
            R.id.btn02 -> cellid = 3
            R.id.btn10 -> cellid = 4
            R.id.btn11 -> cellid = 5
            R.id.btn12 -> cellid = 6
            R.id.btn20 -> cellid = 7
            R.id.btn21 -> cellid = 8
            R.id.btn22 -> cellid = 9
            R.id.reset -> reset.isEnabled = false
        }
        fight(cellid,btn,winner)
    }
    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var current = 1

    private fun fight(cellid:Int,btn:Button,winner:Int){
        if(current == 1){
            btn.text = "O"
            player1.add(cellid)
            current = 2
        }
        else{
            btn.text = "X"
            player2.add(cellid)
            current = 1
        }
        btn.isEnabled = false
        win(winner)
        //disable(btn)
    }

    private fun win(winner:Int){
        winner = 0
        //horizontal
        if(player1.contains(1)&&player1.contains(2)&&player1.contains(3)){
            winner = 1
        }
        if(player2.contains(1)&&player2.contains(2)&&player2.contains(3)){
            winner = 2
        }
        if(player1.contains(4)&&player1.contains(5)&&player1.contains(6)){
            winner = 1
        }
        if(player2.contains(4)&&player2.contains(5)&&player2.contains(6)){
            winner = 2
        }
        if(player1.contains(7)&&player1.contains(8)&&player1.contains(9)){
            winner = 1
        }
        if(player2.contains(7)&&player2.contains(8)&&player2.contains(9)){
            winner = 2
        }

        //vertical
        if(player1.contains(1)&&player1.contains(4)&&player1.contains(7)){
            winner = 1
        }
        if(player2.contains(1)&&player2.contains(4)&&player2.contains(7)){
            winner = 2
        }
        if(player1.contains(2)&&player1.contains(5)&&player1.contains(8)){
            winner = 1
        }
        if(player2.contains(2)&&player2.contains(5)&&player2.contains(8)){
            winner = 2
        }
        if(player1.contains(3)&&player1.contains(6)&&player1.contains(9)){
            winner = 1
        }
        if(player2.contains(3)&&player2.contains(6)&&player2.contains(9)){
            winner = 2
        }

        //diagonal
        if(player1.contains(1)&&player1.contains(5)&&player1.contains(9)){
            winner = 1
        }
        if(player2.contains(1)&&player2.contains(5)&&player2.contains(9)){
            winner = 2
        }
        if(player1.contains(3)&&player1.contains(5)&&player1.contains(7)){
            winner = 1
        }
        if(player2.contains(3)&&player2.contains(5)&&player2.contains(7)){
            winner = 2
        }

        if(winner != 0){
            if(winner == 1){
                Toast.makeText(this,"Player1 Win!!!",Toast.LENGTH_LONG).show()
                disable()
            }
            else{
                Toast.makeText(this,"Player2 Win!!!",Toast.LENGTH_LONG).show()
                disable()
            }
        }
    }
    private fun disable(){
        btn00.isEnabled = false
        btn01.isEnabled = false
        btn02.isEnabled = false
        btn10.isEnabled = false
        btn11.isEnabled = false
        btn12.isEnabled = false
        btn20.isEnabled = false
        btn21.isEnabled = false
        btn22.isEnabled = false
        reset.isEnabled = true
    }

    fun reset(view:View){
//        val btn = view as Button
//        btn.isEnabled=true
//        btn.text = ""
        //play(view)

        btn00.isEnabled = true
        btn01.isEnabled = true
        btn02.isEnabled = true
        btn10.isEnabled = true
        btn11.isEnabled = true
        btn12.isEnabled = true
        btn20.isEnabled = true
        btn21.isEnabled = true
        btn22.isEnabled = true
//        //play(view)
////        reset.isEnabled = false
////
        btn00.text = ""
        btn01.text = ""
        btn02.text = ""
        btn10.text = ""
        btn11.text = ""
        btn12.text = ""
        btn20.text = ""
        btn21.text = ""
        btn22.text = ""
        play(view)
    }
//    private fun playagain(){
//        reset.isEnabled = false
//    }
}
