package com.eclatsol.backgroundservice.statitcnotification.service

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import android.widget.Toast
import androidx.core.app.NotificationCompat
import com.eclatsol.backgroundservice.R

class ForeGroundService : Service() {
    val notification_channel = "Insta"
    val service_id =
        404        //service id ma value zero assign nahi kari shako 0 accpet nathi kartu 0 sivay koi pan number avi shake che
    lateinit var notification: Notification
    lateinit var notificationManager: NotificationManager
    val handler = Handler(Looper.getMainLooper())
    var count = 0
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        createChannel()
        createNotification()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val toastRunnable = object : Runnable{
            override fun run() {
                Toast.makeText(this@ForeGroundService, "$count", Toast.LENGTH_SHORT).show()
                count++
                handler.postDelayed(this,1000)
            }
        }
        handler.postDelayed(toastRunnable,1000)

        startForeground(service_id,notification) //start karishu foreground service
        return START_STICKY
    }

    fun createChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                notification_channel,
                "Foreground",
                NotificationManager.IMPORTANCE_HIGH
            )
            notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    fun createNotification() {
        val build = NotificationCompat.Builder(this, notification_channel)
            .setSmallIcon(R.drawable.ic_launcher_background).setContentTitle("Title")
            .setContentText("body")
        notification = build.build()
    }

    override fun onDestroy() {
        super.onDestroy()
        stopSelf()
    }
}