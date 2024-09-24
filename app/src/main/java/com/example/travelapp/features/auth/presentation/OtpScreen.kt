package com.example.travelapp.features.auth.presentation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.travelapp.common.components.CommonYellowButton
import com.example.travelapp.features.auth.components.TopHeaderCurvedImage
import com.example.travelapp.ui.theme.TravelAppTheme

@Composable
fun OtpScreen(navController: NavHostController) {
	var scrollState = rememberScrollState()
	Surface(
		color = Color.White,
	       ) {
		Column(
			horizontalAlignment = Alignment.CenterHorizontally,
			modifier = Modifier.fillMaxSize()
				.verticalScroll(scrollState)
		      ) {
			
			TopHeaderCurvedImage()
			
			Column(
				horizontalAlignment = Alignment.CenterHorizontally,
				modifier = Modifier
					.fillMaxWidth()
					.padding(15.dp)
			      ) {
				Text("Welcome ! ", style = MaterialTheme.typography.headlineMedium)
				Spacer(modifier = Modifier.height(15.dp))
				
				Text("Enter OTP", style = MaterialTheme.typography.bodyMedium)
				Spacer(modifier = Modifier.height(15.dp))
				
				Row(
					modifier = Modifier
						.fillMaxWidth()
						.padding(horizontal = 16.dp),
					horizontalArrangement = Arrangement.SpaceBetween,
				   ) {
					(1..6).forEach { index ->
						Card(
							shape = RoundedCornerShape(5.dp),
							border =  BorderStroke(1.dp, Color.LightGray),
							colors = CardDefaults.cardColors(
								containerColor = Color.White
															),
							modifier = Modifier
								.width(45.dp)
								.padding(end = 8.dp), //							horizontalAlignment = Alignment.CenterHorizontally,
							//							verticalArrangement = Arrangement.Center
						    ) {							//Spacer(modifier = Modifier.height(8.dp))
							
								Text(
									text = "$index",
									style = MaterialTheme.typography.bodyMedium,
									textAlign = TextAlign.Center,
									modifier = Modifier
										.padding(16.dp)
										.fillMaxWidth(),
								    )
							
							
						}
					}
				}
				
				Spacer(modifier = Modifier.height(100.dp))
				CommonYellowButton(
					text = "VERIFY", onClick = {
						navController.navigate("mainScreen/0"){
							popUpTo(0) { inclusive = true }
							launchSingleTop = true
						}
					},
				                  )
			}
		}
	}
}

@Preview (showBackground = true, showSystemUi = true)
@Composable
fun OtpScreenPreview() {
	TravelAppTheme{
		OtpScreen(navController = rememberNavController())
	}
	
}