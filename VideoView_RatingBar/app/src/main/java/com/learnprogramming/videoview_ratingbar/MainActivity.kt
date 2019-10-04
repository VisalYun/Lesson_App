package com.learnprogramming.videoview_ratingbar

import android.icu.util.Measure
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.MediaController
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    var position =0 //position of video
    var mediaControl:MediaController? = null
    //The MediaController will create a default set of controls and put them in a window floating above your application

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(mediaControl == null){
            mediaControl = MediaController(this@MainActivity)
        }

        try {
            videoView.setMediaController(mediaControl)
            videoView.setVideoURI(Uri.parse("android.resource://" + packageName +"/"+R.raw.video))
        } catch (e: Exception){
            Log.e("Error", e.message)
        }

        videoView.setOnPreparedListener{
            videoView.seekTo(position)
            if(position == 0){
                videoView.start()
            }
            else{
                videoView.pause()
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        if(outState!=null){
            outState.putInt("position",videoView.currentPosition)
        }
        videoView.pause()
    }
}
