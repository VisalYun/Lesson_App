package com.example.webview

import android.os.Bundle;
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                 setContentView(R.layout.activity_main)


                webview.webViewClient = MyWebView()

                btnGo.setOnClickListener {
                        webview.loadUrl("https://" + edtUrl.text.toString())
                }

                btnGoBack.setOnClickListener {
                        if(webview.canGoBack()) {
                                webview.goBack()
                        } else
                                Toast.makeText(this,"No History Available",Toast.LENGTH_SHORT).show()
                }
                btnGoForward.setOnClickListener {
                        if(webview.canGoForward()) {
                                webview.goForward()
                        } else
                                Toast.makeText(this,"No History Available",Toast.LENGTH_SHORT).show()
                }
        }
}