@file:OptIn(ExperimentalPermissionsApi::class)

package com.example.travelapp

import android.Manifest
import android.app.AlertDialog
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.core.view.WindowCompat
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import androidx.navigation.compose.rememberNavController
import com.example.travelapp.common.route.TravelAppNavHost
import com.example.travelapp.ui.theme.TravelAppTheme
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberPermissionState

class MainActivity : ComponentActivity() {
	private val dialogReceiver = object : BroadcastReceiver() {
		override fun onReceive(context: Context, intent: Intent) {
			val title = intent.getStringExtra("title")
			val body = intent.getStringExtra("body")
			showNotificationDialog(title, body)
		}
	}
	private var showDialog by mutableStateOf(false)
	private var dialogTitle by mutableStateOf("")
	private var dialogBody by mutableStateOf("")
	override fun onCreate(savedInstanceState: Bundle?) {
		// Register the BroadcastReceiver
		LocalBroadcastManager.getInstance(this)
			.registerReceiver(dialogReceiver, IntentFilter("SHOW_DIALOG"))



		super.onCreate(savedInstanceState)
		enableEdgeToEdge()
		WindowCompat.setDecorFitsSystemWindows(window, false)
		
		setContent {
			
			TravelAppTheme {
				val notificationPermissionState = rememberPermissionState(permission = Manifest.permission.POST_NOTIFICATIONS)

				val navController = rememberNavController()

				LaunchedEffect(Unit) {
					notificationPermissionState.launchPermissionRequest()
				}



					if (showDialog) {
						NotificationDialog(
							title = dialogTitle,
							body = dialogBody,
							onDismiss = {
								showDialog = false
							}
						)
					}
				Surface {
					TravelAppNavHost(navController = navController)
				//					AuthWrapper(navHostController = navController)
				}
				
				
			}
		}
	}
	override fun onDestroy() {
		super.onDestroy()
		// Unregister the receiver
		LocalBroadcastManager.getInstance(this).unregisterReceiver(dialogReceiver)
	}

//	override  fun onResume() {
//
//	}
//
//	override fun onPause() {
//		super.onPause()
//	}
//
//	override fun onStart() {
//		super.onStart()
//	}
//
//	override fun onStop() {
//		super.onStop()
//	}
//
//	override fun onRestart() {
//		super.onRestart()
//	}
//
//

	override fun onNewIntent(intent: Intent) {
		super.onNewIntent(intent)
	}

	private fun showNotificationDialog(title: String?, body: String?) {
		dialogTitle = title ?: "Notification"
		dialogBody = body ?: ""
		showDialog = true
	}
}




@Composable
fun ProfileScreen() {
	Text(text = "Profile Screen")
}


@Composable
fun NotificationDialog(title: String, body: String, onDismiss: () -> Unit) {
	AlertDialog(
		onDismissRequest = onDismiss,
		title = { Text(text = title) },
		text = { Text(text = body) },
		confirmButton = {
			Button(
				onClick = onDismiss) {
				Text("OK")
			}
		}
	)
}
