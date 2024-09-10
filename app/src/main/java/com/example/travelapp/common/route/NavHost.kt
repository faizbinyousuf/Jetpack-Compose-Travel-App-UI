package com.example.travelapp.common.route

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.travelapp.HomeScreen
import com.example.travelapp.OrdersScreen
import com.example.travelapp.ProfileScreen
import com.example.travelapp.features.auth.AuthWrapper
import com.example.travelapp.features.auth.LoginScreen
import com.example.travelapp.features.auth.SignUpScreen

@Composable
fun TravelAppNavHost(navController: NavHostController) {
	NavHost(navController, startDestination = "authWrapper") {
		composable("authWrapper") { AuthWrapper(navHostController = navController) }
		composable("login") { LoginScreen() }
		composable("signup") { SignUpScreen() }
		composable("status") { HomeScreen() }
		
		composable("send") { OrdersScreen() }
		composable("Settings") { ProfileScreen() }
	}
}
