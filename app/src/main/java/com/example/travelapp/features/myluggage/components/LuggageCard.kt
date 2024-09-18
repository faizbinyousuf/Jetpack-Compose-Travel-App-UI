package com.example.travelapp.features.myluggage.components


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
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.travelapp.R
import com.example.travelapp.common.CustomStepper
import com.example.travelapp.ui.theme.TravelAppTheme


@Composable
fun LuggageCard() {
	
	val numberStep = 3
	var currentStep by rememberSaveable { mutableStateOf(3) }
	val titleList = arrayListOf("Accepted", "Confirmed", "Delivered")
	
	
	val pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)
	var dottedGrey = colorResource(id = R.color.app_gray)
	
	Card(
		shape = RoundedCornerShape(16.dp),
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
				
				Column(
					  ) {
					Spacer(modifier = Modifier.height(8.dp))
					Text(
						text = "DXB - SFO",
						style = MaterialTheme.typography.bodyLarge,
						fontWeight = FontWeight.Bold)
					Spacer(modifier = Modifier.height(5.dp))
					
					Row(verticalAlignment = Alignment.CenterVertically) {
						Image(
							painter = painterResource(id = R.drawable.weight_svg),
							contentDescription = "Weight Icon",
							colorFilter =  ColorFilter.tint(colorResource(id = R.color.app_yellow)),
							modifier = Modifier.size(20.dp))
						
						Spacer(modifier = Modifier.width(8.dp))
						
						Text(
							text = "1 KG", style = MaterialTheme.typography.bodyMedium.copy(
								fontWeight = FontWeight.Bold,
								color = colorResource(id = R.color.app_gray)))
						
						
								
						
						//				Spacer(modifier = Modifier.width(16.dp))
						//
					
					}
					Spacer(modifier = Modifier.height(5.dp))
					Text(
						text = "Item Name",
						style = MaterialTheme.typography.bodyMedium,
						fontWeight = FontWeight.Bold)
					
				}
				var deliveredIcon = painterResource(id = R.drawable.delivered_svg)
				Spacer(modifier = Modifier.weight(2F))
				
				Image(
					painter = deliveredIcon,
					contentDescription = "Delivered",
					modifier = Modifier.size(50.dp)
						
					 )
			}
			
			Spacer(modifier = Modifier.height(8.dp))
			
			// Weight Info Row
			
			
			Spacer(modifier = Modifier.height(8.dp))
			
			
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



@Preview
@Composable
fun LuggageCardPreview() {
	TravelAppTheme {
		LuggageCard()
	}
}
