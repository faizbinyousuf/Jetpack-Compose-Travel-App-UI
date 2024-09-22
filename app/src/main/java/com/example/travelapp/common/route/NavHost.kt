package com.example.travelapp.common.route

import androidx.compose.animation.slideIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOut
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.IntOffset
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.travelapp.ImagePickerScreen
import com.example.travelapp.ProfileScreen
import com.example.travelapp.common.components.MainScreen
import com.example.travelapp.features.auth.presentation.AuthWrapper
import com.example.travelapp.features.auth.presentation.LoginScreen
import com.example.travelapp.features.auth.presentation.OtpScreen
import com.example.travelapp.features.auth.presentation.RegistrationScreen
import com.example.travelapp.features.find.AngelListingScreen
import com.example.travelapp.features.find.BookingConfirmation
import com.example.travelapp.features.find.BookingSummary
import com.example.travelapp.features.find.FindAngels
import com.example.travelapp.features.find.KnowAngel
import com.example.travelapp.features.send.components.SendScreen
import com.example.travelapp.features.status.presentation.HomeScreen
import com.example.travelapp.features.trip.presentation.TripScreen


@Composable
fun TravelAppNavHost(navController: NavHostController) {
	NavHost(
		
		
		
		navController, startDestination = "authWrapper",
		
		enterTransition = {
						  slideInHorizontally()
		},
		
		
		) {
		composable("authWrapper") { AuthWrapper(navHostController = navController) }
		composable("login") { LoginScreen(navHostController = navController) }
		composable("signup") { RegistrationScreen(navController = navController) }
		composable("status") { HomeScreen(navController = navController) }
		
		composable("send") { SendScreen(navController = navController) }
		
		
		composable("findAngels") { FindAngels(navController = navController) }
		
		composable("angelListScreen") { AngelListingScreen(navController = navController) }
		
		composable("knowAngel") { KnowAngel(navController = navController) }
		
		composable("bookingSummary") { BookingSummary(navController = navController) }
		
		
		composable("otpScreen") { OtpScreen(navController = navController) }
		
		composable("bookingConfirmation") { BookingConfirmation(navController = navController) }
		
		
		
		
		
		
		
		composable("mainScreen") { MainScreen(navController = navController) }
		composable("Settings") { ProfileScreen() }
		
		
		/// Trip related
		composable("trips") { TripScreen(navController = navController) }

		composable("cameraScreen") { ImagePickerScreen() }
		
		
		
		/// routes for sending item
		
		
	}
}
