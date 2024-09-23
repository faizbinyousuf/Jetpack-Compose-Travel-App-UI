package com.example.travelapp.Firebase

import android.app.ActivityManager
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.NotificationManager.IMPORTANCE_DEFAULT
import android.app.PendingIntent
import android.app.PendingIntent.FLAG_IMMUTABLE
import android.content.Context
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.example.travelapp.MainActivity
import com.example.travelapp.R
import com.example.travelapp.dataStore
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class FirebaseService : FirebaseMessagingService() {

    // initialise handlers

    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)

        // Create the notification channel (if necessary) when a message is received
//        val channelId = "your_channel_id"
//        val channelName = "Your Channel Name"
//        val importance = NotificationManager.IMPORTANCE_HIGH
//        val channel = NotificationChannel(channelId, channelName, importance)
//        channel.description = "Your Channel Description"
//        val notificationManager: NotificationManager =
//            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
//        notificationManager.createNotificationChannel(channel)

        // Log the received message
        Log.v("FCM Message Received", "From ${message.from}")
//        Log.v( "FCM Message Received", "From ${message.data}")
//        Log.v( "FCM Message Received", "From ${message.notification}")
//        Log.v( "FCM Message Received", "From ${message.messageId}")
//        Log.v( "FCM Message Received", "From ${message.sentTime}")
//        Log.v( "FCM Message Received", "From ${message.ttl}")



        if (message.data.isNotEmpty()) {

            Log.v("FCM Message Received", "Message Data is  ${message.data}")
            // println("Message Data Payload: ${message.data}")

        }

        message.data.let {

            Log.v("FCM Message Received", "Message Data is ${message.data}")

        }
        message.notification?.let {
            // show notification even app is in foreground

            if (isAppInForeground()) {
                val notification = message.notification!!
                // Send an event to the UI to show a dialog
                val intent = Intent("SHOW_DIALOG")
                intent.putExtra("title", notification.title)
                intent.putExtra("body", notification.body)
                LocalBroadcastManager.getInstance(this).sendBroadcast(intent)
            } else {
                // Show the notification if the app is in the background
                sendNotification(message.notification!!)
            }



            Log.v("FCM Message Received", "Message Notification title is ${message.notification!!.title}")
            Log.v("FCM Message Received", "Message Notification body is ${message.notification!!.body}")

        }


    }

    @OptIn(DelicateCoroutinesApi::class)
    override fun onNewToken(token: String) {
        super.onNewToken(token)
        //save token in data store


        GlobalScope.launch {
//            dataStore.saveToken(token)
            saveFCMToken(token)
        }

    }



    private suspend fun saveFCMToken(token: String) {


        val fcmTokenKey = stringPreferencesKey("fcm_token")
        baseContext.dataStore.edit { pref ->
            pref[fcmTokenKey] = token
        }


    }


    private fun isAppInForeground(): Boolean {
        val activityManager = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        val runningAppProcesses = activityManager.runningAppProcesses ?: return false
        for (processInfo in runningAppProcesses) {
            if (processInfo.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND && processInfo.processName == packageName) {
                return true
            }
        }
        return false
    }

    private fun sendNotification(message: RemoteMessage.Notification) {
        val intent = Intent(this, MainActivity::class.java).apply {
            addFlags(FLAG_ACTIVITY_CLEAR_TOP)
        }

        val pendingIntent = PendingIntent.getActivity(
            this, 0, intent, FLAG_IMMUTABLE
        )

        // comment test

        val channelId = this.getString(R.string.default_notification_channel_id)

        val notificationBuilder = NotificationCompat.Builder(this, channelId)
            .setContentTitle(message.title)
            .setContentText(message.body)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setAutoCancel(true)
            .setContentIntent(pendingIntent)

        val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val CHANNEL_NAME  = "Travel App"
            val channel = NotificationChannel(channelId, CHANNEL_NAME, IMPORTANCE_DEFAULT)
            manager.createNotificationChannel(channel)
        }
        var randomNumber  = (1..10000).random()

        manager.notify(randomNumber, notificationBuilder.build())
    }


}