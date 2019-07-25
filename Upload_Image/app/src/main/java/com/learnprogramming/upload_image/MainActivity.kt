package com.learnprogramming.upload_image

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.view.View
import android.widget.Toast
import java.net.URI

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun imageSelect(v:View){
        //check permission
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
//            if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED){
//                //permission denied
//                val permissions = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE);
//                //show popup to request runtime permission
//                requestPermissions(permissions, 10);
//            }
//            else{
//                //permission already granted
//                val i = Intent(Intent.ACTION_PICK)
//                i.type = "image/*"
//                startActivityForResult(i,1)
//            }
//        }
//        else{
//            //system OS is < Marshmallow
//            val i = Intent(Intent.ACTION_PICK)
//            i.type = "image/*"
//            startActivityForResult(i,1)
//        }
        val i = Intent(Intent.ACTION_PICK)
        i.type = "image/*"
        startActivityForResult(i,1)
    }
    //handle requested permission result
//    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
//        when(requestCode){
//            10 -> {
//                if (grantResults.size >0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
//                    //permission from popup granted
//                    val i = Intent(Intent.ACTION_PICK)
//                    i.type = "image/*"
//                    startActivityForResult(i,1)
//                }
//                else{
//                    //permission from popup denied
//                    Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show()
//                }
//            }
//        }
//    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(resultCode == Activity.RESULT_OK){
            if(requestCode==1){
                var seletedImage = data?.data
                val intent = Intent(this,second::class.java)
                intent.putExtra("uri",seletedImage.toString())
                startActivity(intent)
            }
        }
        super.onActivityResult(requestCode, resultCode, data)
    }
}
