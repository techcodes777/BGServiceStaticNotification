package com.eclatsol.backgroundservice.demo

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MyService : Service() {
    override fun onBind(intent: Intent?): IBinder? {
        logPrint("onBind")
        return null
    }

    override fun onCreate() {
        super.onCreate()
        logPrint("onCreate")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        logPrint("onStartCommand")
        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        logPrint("onDestroy")

    }

    private fun logPrint(logPrint : String) {
        Log.e("NormalBgService", "logPrint: $logPrint")
    }
}