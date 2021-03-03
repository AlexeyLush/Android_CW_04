package kz.step.android_cw_04

import android.content.ActivityNotFoundException
import android.content.Intent
import android.content.pm.PackageManager
import android.hardware.Camera
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import androidx.core.app.ActivityCompat
import java.util.jar.Manifest

class MainActivity : AppCompatActivity() {

    var buttonCamera: Button? = null
    var buttonPhone: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeViews()
        initializeListeners()
    }

    fun initializeViews(){
        buttonCamera = findViewById<Button>(R.id.button_main_activity_open_camera)
        buttonPhone = findViewById<Button>(R.id.button_main_activity_call)
    }

    fun initializeListeners(){
        buttonCamera?.setOnClickListener{
            val REQUEST_IMAGE_CAPTURE = 1

            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            try {
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
            } catch (e: ActivityNotFoundException) {

            }
        }

        buttonPhone?.setOnClickListener{
            var phoneIntent: Intent = Intent(Intent.ACTION_CALL)
            phoneIntent.setData(Uri.parse("tel:0000000000000g"))
//            if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
//                return@setOnClickListener
//            }
            startActivity(phoneIntent)
        }
    }



}