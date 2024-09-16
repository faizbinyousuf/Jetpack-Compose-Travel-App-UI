package com.example.travelapp.features.find

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.unit.sp
import com.example.travelapp.R
import com.example.travelapp.common.components.CommonYellowButton
import com.example.travelapp.ui.theme.TravelAppTheme

@Composable
fun BookingConfirmation() {
	Scaffold(
		containerColor = Color.White) {
		Column(
			horizontalAlignment = Alignment.CenterHorizontally,
			verticalArrangement = Arrangement.Center,
			modifier = Modifier
				.fillMaxSize()
				.padding(it)
				.padding(15.dp)) {
			
			var painter = painterResource(id = R.drawable.done)
			
			Image(
				
				modifier = Modifier
					
					.padding(bottom = 30.dp)
					.size(75.dp),
				
				painter = painter, contentDescription = null, contentScale = ContentScale.Crop,
			     )
			Text(
				"Once the angel accepts, we will notify you",
				
				modifier = Modifier
					
					.padding(bottom = 30.dp),
				
				textAlign = TextAlign.Center,
				
				style = MaterialTheme.typography.headlineMedium.copy(
					fontSize = 35.sp))
			
			Spacer(modifier = Modifier.height(200.dp))
			
			CommonYellowButton(text = "DONE", onClick = { /*TODO*/ }
			                  
			                  
			                  )
		}
	}
	
}

@Composable
@Preview
fun PreviewBookingConfirmation() {
	TravelAppTheme {
		BookingConfirmation()
	}
}