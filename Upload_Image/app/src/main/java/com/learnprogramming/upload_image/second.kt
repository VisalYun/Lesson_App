package com.learnprogramming.upload_image

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*

class second : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        var image = intent.getStringExtra("uri")
        var uri = Uri.parse(image)
        imageView.setImageURI(uri)
    }
}
