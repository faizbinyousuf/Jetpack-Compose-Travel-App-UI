package com.example.travelapp.common.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun MainScreen(navHostController: NavHostController) {
	Scaffold(
		
		bottomBar = { CustomBottomNavigation(navHostController = navHostController) }
	        
	        ) { innerPadding ->
		Box(modifier = Modifier.padding(innerPadding)) {
		
		}
		
	}
}