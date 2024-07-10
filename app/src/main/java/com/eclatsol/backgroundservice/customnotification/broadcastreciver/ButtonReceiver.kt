package com.eclatsol.backgroundservice.customnotification.broadcastreciver

import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import com.eclatsol.backgroundservice.ui.SecondActivity
import com.eclatsol.backgroundservice.ui.ThirdActivity

class ButtonReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Log.e("ffbfdbf", "onReceive: ")


        when (intent?.action) {
            "BUTTONACTION" -> {
                val msg = intent.extras?.getString("msg") ?: "Not Found"

                when (msg) {
                    "btn1" -> {
                        closeNotificationControBar(context)
                        activityIntent(
                            context,
                            context?.packageName.toString(),
                            "com.eclatsol.backgroundservice.ui.FirstActivity"
                        )
                    }

                    "btn2" -> {
                        closeNotificationControBar(context)
                        activityIntent(
                            context,
                            context?.packageName.toString(),
                            "com.eclatsol.backgroundservice.ui.SecondActivity"
                        )
                    }

                    "btn3" -> {
                        closeNotificationControBar(context)
                        activityIntent(
                            context,
                            context?.packageName.toString(),
                            "com.eclatsol.backgroundservice.ui.ThirdActivity"
                        )
                    }

                    else -> {

                    }
                }
            }

            else -> {
                Log.d("fdfdfdsfd", "onReceive: Failed")
            }
        }
    }

    @SuppressLint("WrongConstant")
    private fun closeNotificationControBar(context: Context?) {
        try {
            val statusBarService = context?.getSystemService("statusbar")
            val statusBarManager = Class.forName("android.app.StatusBarManager")
            val collapsePanelsMethod = statusBarManager.getMethod("collapsePanels")
            collapsePanelsMethod.invoke(statusBarService)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun activityIntent(context: Context?, packageName: String, activity: String) {
        val intent = Intent()
        intent.setClassName(packageName, activity)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        context!!.startActivity(intent)
    }
}