package com.example.travelapp.features.trip.presentation

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.content.MediaType.Companion.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.travelapp.R
import com.example.travelapp.common.components.AddTripLuggageButton
import com.example.travelapp.common.components.CommonAppBar
import com.example.travelapp.common.components.CommonYellowButton
import com.example.travelapp.features.trip.components.TripCard
import com.example.travelapp.ui.theme.buttonLabelStyle

@Composable
fun TripScreen(
	navController: NavHostController
			  ) {
	
	BackHandler {
		navController.navigate("mainScreen") {
			popUpTo(0) { inclusive = true }
			launchSingleTop = true
		}
	}
	Scaffold(containerColor = Color.White, topBar = {
		CommonAppBar(
			title = "Trips")
	}) {
		Column(
			horizontalAlignment =  Alignment.CenterHorizontally,
			modifier = Modifier
				.padding(it)
				.fillMaxWidth()
				.padding(
					horizontal = 15.dp)
			  ) {
			
			TopImageSection()
			AddTripLuggageButton(label = "Add New Trip")
//			Text(
//
//				"You don’t have any upcomming trips Please add it",
//				style =  MaterialTheme.typography.headlineMedium,
//				textAlign = TextAlign.Center,
//				modifier = Modifier.padding(top = 15.dp)
//				)
			
			TripCard()
			
			
		}
	}
}

@Composable
fun TopImageSection() {
	var painter = painterResource(id = R.drawable.trip_top_image)
	Image(
		painter = painter,
		contentDescription = null,
		contentScale = ContentScale.Fit
		,

		modifier = Modifier
			
			.fillMaxWidth()
			
			.height(120.dp)
	)
}