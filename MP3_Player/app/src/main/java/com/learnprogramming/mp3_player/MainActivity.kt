package com.learnprogramming.mp3_player

import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import android.widget.ViewAnimator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mp: MediaPlayer
    var position =0
    var index:Int = 10
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var songArrays = resources.getStringArray(R.array.songlist)
        var arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1,songArrays)
        song_list.adapter = arrayAdapter

        song_list.setOnItemClickListener{ adapterView, view, i, l ->
//            if(mp.isPlaying()){
//                mp.pause()
//                index = i
//                play(index)
//                Toast.makeText(this,"${songArrays[i]} is playing...",Toast.LENGTH_SHORT).show()
//            }
//            else{
                index = i
                play(index)
                Toast.makeText(this,"${songArrays[i]} is playing...",Toast.LENGTH_SHORT).show()
            //}
        }
    }

    fun oca(){
        mp = MediaPlayer.create(this, R.raw.one_call_away)
        mp.start()
    }
    fun ct(){
        mp = MediaPlayer.create(this, R.raw.cheap_thrill)
        mp.start()
    }
    fun dwk(){
        mp = MediaPlayer.create(this, R.raw.dwk)
        mp.start()
    }
    fun ll(){
        mp = MediaPlayer.create(this, R.raw.lily)
        mp.start()
    }
    fun b(){
        mp = MediaPlayer.create(this, R.raw.boy)
        mp.start()
    }

    fun play(i:Int){
        when(i){
            0 -> {
                oca()
            }
            1 -> {
                ct()
            }
            2 -> {
                dwk()
            }
            3 -> {
                ll()
            }
            4 -> {
                b()
            }
        }
        play.isEnabled=false

    }

    fun pause(v:View){
        if(mp.isPlaying()){
            position = mp.currentPosition
            mp.pause()
        }
        pause.isEnabled = false
        play.isEnabled = true
    }

    fun con(v:View){
        if(index == 10){
            oca()
        }
        else{
            if (mp.isPlaying() == false) {
                mp.seekTo(position)
                mp.start()
            }
        }
        play.isEnabled = false
        pause.isEnabled = true
    }

    fun next(v:View){
        if(index<4){
            index+=1
            if(mp.isPlaying){
                mp.pause()
                play(index)
            }
        }
        else{
            index=0
            if(mp.isPlaying){
                mp.pause()
                play(index)
            }
        }
    }

    fun pre(v:View){
        if(index>0){
            index-=1
            if(mp.isPlaying){
                mp.pause()
                play(index)
            }
        }
        else{
            index=4
            if(mp.isPlaying){
                mp.pause()
                play(index)
            }
        }
    }

    override fun onDestroy () {
        super.onDestroy ()
        mp.release()
    }
}
