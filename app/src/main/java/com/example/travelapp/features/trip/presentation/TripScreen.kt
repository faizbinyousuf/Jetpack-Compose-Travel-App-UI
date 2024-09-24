package com.example.travelapp.features.trip.presentation

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.travelapp.R
import com.example.travelapp.common.components.AddTripLuggageButton
import com.example.travelapp.common.components.CommonAppBar
import com.example.travelapp.features.trip.components.TripCard
import com.example.travelapp.ui.theme.TravelAppTheme

@Composable
fun TripScreen(
	navController: NavHostController
              ) {
	
	BackHandler {
		navController.navigate("mainScreen/0") {
			popUpTo(0) { inclusive = true }
			launchSingleTop = true
		}
	}
	var scrollState = rememberScrollState()
	Scaffold(contentWindowInsets = WindowInsets(0.dp), containerColor = Color.White, topBar = {
		CommonAppBar(   navController = navController,
			title = "Trips")
	}) {
		Column(
			horizontalAlignment = Alignment.CenterHorizontally,
			modifier = Modifier
				.padding(it)
				.verticalScroll(scrollState)
				.fillMaxWidth()
				.padding(
					horizontal = 15.dp)) {
			
			TopImageSection()
			AddTripLuggageButton(label = "Add New Trip")



			Spacer(modifier = Modifier.height(15.dp))

//						Text(
//
//							"You don’t have any upcomming trips Please add it",
//							style =  MaterialTheme.typography.headlineMedium,
//							textAlign = TextAlign.Center,
//							modifier = Modifier.padding(top = 15.dp)
//							)
//
			
			(1..3).forEach {
				TripCard()
			}
			Spacer(modifier = Modifier.height(30.dp))


		}
	}
}

@Composable
fun TopImageSection() {











	var painter = painterResource(id = R.drawable.trip_top_image)
	Image(
		painter = painter, contentDescription = null, contentScale = ContentScale.Fit,
		
		modifier = Modifier
			
			.fillMaxWidth()
			
			.height(120.dp))
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TripScreenPreview() {
	TravelAppTheme {
		
		TripScreen(navController = rememberNavController())
		
	}
	
}