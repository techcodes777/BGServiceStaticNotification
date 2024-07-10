package com.eclatsol.backgroundservice

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.eclatsol.backgroundservice.service.ForeGroundService

class NotificationActivity : AppCompatActivity() {
    val permissionCode = 100
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)

        findViewById<Button>(R.id.btnSendNotification).setOnClickListener {

            checkUserPermission()
        }
    }

    private fun checkUserPermission() {
        if (ContextCompat.checkSelfPermission(
                this,
                android.Manifest.permission.POST_NOTIFICATIONS
            ) != PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(
                this,
                android.Manifest.permission.FOREGROUND_SERVICE
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(
                    android.Manifest.permission.POST_NOTIFICATIONS,
                    android.Manifest.permission.FOREGROUND_SERVICE
                ),
                permissionCode //Permission nathi mali to aa call thashe
            )
        } else {
            //permission mali gay che aa else part call thay che
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                startForegroundService(Intent(this, ForeGroundService::class.java)) //aa vali method latest android mate use thay che
            }else{
                startService(Intent(this,ForeGroundService::class.java)) //aa vali method juna android mate use thay che
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        //apne je request code pass karvi shavi //Request code mokalvi shavi te same che ke nai
        //onRequestPermissionsResult override method call karvani jarur atle padi ke permission check thay che tyare khali
        //Jo permission nathi api to pela if part call thashe else part thashe nathi te call thahe second time per
        //Permission mali gaya pasi foreground service ne start to karvi pade ne
        when(requestCode){
            permissionCode ->{
                if (grantResults.isNotEmpty()&&grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        startForegroundService(Intent(this, ForeGroundService::class.java)) //aa vali method latest android mate use thay che
                    }else{
                        startService(Intent(this,ForeGroundService::class.java)) //aa vali method juna android mate use thay che
                    }
                }
            }
        }
    }
}