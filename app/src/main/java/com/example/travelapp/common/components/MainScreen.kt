package com.example.travelapp.common.components

import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import com.example.travelapp.features.find.FindAngels
import com.example.travelapp.features.send.components.SendScreen
import com.example.travelapp.features.status.presentation.HomeScreen
import com.example.travelapp.features.trip.presentation.TripScreen


@Composable
fun MainScreen(navController: NavHostController) {
	var selectedIndex by rememberSaveable { mutableStateOf(0) }
	var showExitDialog by remember { mutableStateOf(false) }
	
	
	BackHandler {
		showExitDialog = true // Show the confirmation dialog on back press
	}
	
	Scaffold(
		
		bottomBar = {
			
			CustomBottomNavigation(selectedIndex = selectedIndex, onItemSelected = { newIndex ->
				selectedIndex = newIndex
			}, selectedRoute = screenArray[selectedIndex], navHostController = navController)
			
			
		}
	        
	        ) {
		
		Box(modifier = Modifier.padding(it)) {
			when (selectedIndex) {
				0 -> {
					HomeScreen(navController = navController)
				}
				
				1 -> {
					SendScreen(navController = navController)
				}
				
				2 -> {
					FindAngels(navController = navController)
				}
				
				3 -> {
					
					TripScreen(navController = navController)
				}
			}
			
			
		}
		
		
	}
	
	if (showExitDialog) {
		val activity = (LocalContext.current as? Activity)
		ExitConfirmationDialog(onConfirm = {
			
			
			activity?.finish()
		}, onDismiss = { showExitDialog = false })
	}
}

var screenArray = arrayOf("status", "send", "findAngels", "profile")