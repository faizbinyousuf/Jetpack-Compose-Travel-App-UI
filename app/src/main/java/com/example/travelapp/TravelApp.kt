package com.example.travelapp

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.google.firebase.messaging.FirebaseMessaging


// create singleton class for Data store

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "local_storage")
class TravelApp: Application() {
    override fun onCreate() {
        super.onCreate()
        FirebaseMessaging.getInstance().token.addOnCompleteListener { task ->
            if (task.isSuccessful) {
                // FCM token
                val token = task.result
                Log.d("FCM Token", "FCM Token: $token")
            } else {
                Log.w("FCM Token", "Fetching FCM token failed", task.exception)
            }
        }
    }


}