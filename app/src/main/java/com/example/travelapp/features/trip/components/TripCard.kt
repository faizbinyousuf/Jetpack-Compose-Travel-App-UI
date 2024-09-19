package com.example.travelapp.features.trip.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.vector.VectorProperty
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.travelapp.R
import com.example.travelapp.common.CustomStepper


@Composable
fun TripCard() {
	
	val numberStep = 3
	var currentStep by rememberSaveable { mutableStateOf(3) }
	val titleList = arrayListOf("Accepted", "Confirmed", "Delivered")
	
	
	val pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)
	var dottedGrey = colorResource(id = R.color.app_gray)
	
	Card(
		shape = RoundedCornerShape(16.dp),
		colors = CardDefaults.cardColors(containerColor = Color.White),
		elevation = CardDefaults.cardElevation(8.dp),
		modifier = Modifier
			.padding(top = 5.dp, bottom = 8.dp)
			.fillMaxWidth()) {
		Column(modifier = Modifier.padding(16.dp)) {            // First Row with Image and Main Trip Info
			Row(
				verticalAlignment = Alignment.CenterVertically) {
				Box(
					modifier = Modifier
						.size(65.dp)
						.background(colorResource(id = R.color.app_yellow), shape = CircleShape),
					contentAlignment = Alignment.Center) {
					Text(
						text = "Luggage\nPhoto",
						color = Color.Black,
						fontSize = 10.sp,
						textAlign = TextAlign.Center)
				}
				
				Spacer(modifier = Modifier.width(16.dp))
				
				Column {
					Text(
						text = "DXB - SFO",
						style = MaterialTheme.typography.bodyLarge,
						fontWeight = FontWeight.Bold)
					Text(
						text = "Added on: Saturday 30 May 2021",
						style = MaterialTheme.typography.bodySmall.copy(
							color = colorResource(id = R.color.app_gray)))
					
				}
			}
			
			Spacer(modifier = Modifier.height(8.dp))
			
			// Weight Info Row
			Row(verticalAlignment = Alignment.CenterVertically) {
				Image(
					painter = painterResource(id = R.drawable.weight_svg),
					contentDescription = "Weight Icon",
					modifier = Modifier.size(20.dp))
				
				Spacer(modifier = Modifier.width(8.dp))
				
				Text(
					text = "1 KG", style = MaterialTheme.typography.bodyMedium)
				
				Spacer(modifier = Modifier.width(16.dp))
				
				Text(
					text = "Product Name / Category",
					style = MaterialTheme.typography.bodyMedium,
					fontWeight = FontWeight.Bold)
			}
			
			Spacer(modifier = Modifier.height(8.dp))
			
			// Product Description Text
			Text(
				text = "Product Description Offer message Lorem Ipsum is simply dummy text of the",
				style = MaterialTheme.typography.bodySmall.copy(
					fontWeight = FontWeight.W500, color = colorResource(id = R.color.app_gray))
			    
			    
			    )
			
			Spacer(modifier = Modifier.height(8.dp))
			
			Canvas(
				Modifier
					.fillMaxWidth()
					.height(1.dp)) {
				
				drawLine(

					color = dottedGrey,
					start = Offset(0f, 0f),
					end = Offset(size.width, 0f),
					pathEffect = pathEffect)
			}
			
			Spacer(modifier = Modifier.height(8.dp))
			
			// User Row with Image and Details
			Row(verticalAlignment = Alignment.CenterVertically) {
				Image(
					painter = painterResource(id = R.drawable.home_header),
					contentDescription = "User Image",
					contentScale = ContentScale.Crop,
					modifier = Modifier
						.size(30.dp)
						.clip(CircleShape)
						.border(
							width = 1.dp, color = Color.Black, shape = CircleShape))
				
				Spacer(modifier = Modifier.width(8.dp))
				
				Row(
					verticalAlignment = Alignment.CenterVertically) {
					Text(
						text = "Faiz Yusuf",
						style = MaterialTheme.typography.bodyMedium.copy(
							fontWeight = FontWeight.Bold,
						                                                ),
						
						)
					var deliveredIcon = painterResource(id = R.drawable.delivered_svg)
					Spacer(modifier = Modifier.width(8.dp))
					Image(
						painter = deliveredIcon,
						contentDescription = "Delivered",
						modifier = Modifier.size(20.dp))
					Spacer(modifier = Modifier.weight(1f))
					Text(
						"Delivered",
						
						style = MaterialTheme.typography.bodyMedium.copy(
							fontWeight = FontWeight.W500, fontSize = 10.sp, color = Color.Black,
							
							
							),
						
						modifier = Modifier
							.align(Alignment.Top)
							.background(
								color = colorResource(id = R.color.app_yellow),
								shape = RoundedCornerShape(25.dp))
							.padding(horizontal = 8.dp, vertical = 6.dp)
					    
					    )
					
				}
				
				//
				
				
			}
			
			Spacer(modifier = Modifier.height(8.dp))
			
			// Action Icons Row
			Row(
				horizontalArrangement = Arrangement.spacedBy(40.dp),
				modifier = Modifier
					.padding(top = 8.dp, start = 40.dp)
					.fillMaxWidth()) {
				Image(
					painter = painterResource(id = R.drawable.phone_call_svg),
					contentDescription = "Chat",
					modifier = Modifier.size(25.dp)
				     
				     )
				
				Image(
					painter = painterResource(id = R.drawable.chat_png),
					contentDescription = "Chat",
					modifier = Modifier.size(25.dp)
				     
				     )
			}
			
//			Spacer(modifier = Modifier.height(8.dp))
			
			
			
			CustomStepper(
				
				modifier = Modifier.padding(0.dp),
				
				
				selectedColor = colorResource(id = R.color.app_yellow),
				numberOfSteps = numberStep,
				currentStep = currentStep,
				stepDescriptionList = titleList)
			
			
		}
		
	}
}

@Composable
fun StatusProgressBar() {
	Row(
		verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
		Text(
			text = "Accepted", style = MaterialTheme.typography.bodySmall)
		
		Spacer(modifier = Modifier.width(8.dp))
		
		LinearProgressIndicator(
			progress = 0.5f,
			color = Color.Yellow,
			trackColor = Color.Gray,
			modifier = Modifier
				.weight(1f)
				.height(8.dp))
		
		Spacer(modifier = Modifier.width(8.dp))
		
		Text(
			text = "Delivered", style = MaterialTheme.typography.bodySmall)
	}
}
