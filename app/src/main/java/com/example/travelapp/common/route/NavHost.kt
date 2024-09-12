package com.example.travelapp.common.route

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import com.example.travelapp.OrdersScreen
import com.example.travelapp.ProfileScreen
import com.example.travelapp.features.auth.presentation.AuthWrapper
import com.example.travelapp.features.auth.presentation.LoginScreen
import com.example.travelapp.features.auth.presentation.RegistrationScreen
import com.example.travelapp.features.find.FindAngels
import com.example.travelapp.features.send.components.SendScreen
import com.example.travelapp.features.status.presentation.HomeScreen


@Composable
fun TravelAppNavHost(navController: NavHostController) {
	NavHost(navController, startDestination = "authWrapper") {
		composable("authWrapper") { AuthWrapper(navHostController = navController) }
		composable("login") { LoginScreen(navHostController = navController) }
		composable("signup") { RegistrationScreen(navController = navController) }
		composable("status") { HomeScreen(navController = navController) }
		composable("findAngels") { FindAngels(navController = navController) }
		
		
		
		composable("send") { SendScreen( navController = navController ) }
		composable("Settings") { ProfileScreen() }
	}
}
