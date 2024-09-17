package com.example.travelapp.features.find.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.Icons

import androidx.compose.ui.ExperimentalComposeUiApi // If using @ExperimentalComposeUiApi annotations
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import com.example.travelapp.R
import com.example.travelapp.common.components.CardWithoutTonalElevation


@Composable
fun TripInfoCard(selected: Boolean, onClick: () -> Unit = {}) {
	CardWithoutTonalElevation(
		elevation = 3.dp,
		gradientRequired = false,
		border =  if(selected) BorderStroke(3.dp, color = colorResource(id = R.color.app_yellow)) else null,
		modifier = Modifier
			.padding(top = 10.dp)
			.fillMaxWidth()
			.clickable {
				onClick()
			}
		,
		shape = RoundedCornerShape(16.dp)
		,
		
		//elevation = CardDefaults.cardElevation(3.dp)
	    ) {
		Column(
			modifier = Modifier
				.padding(16.dp)
		      ) {
			Row(
				modifier = Modifier.fillMaxWidth(),
				horizontalArrangement = Arrangement.SpaceBetween,
				verticalAlignment = Alignment.CenterVertically
			   ) {
				// DXB Section
				Column(horizontalAlignment = Alignment.CenterHorizontally) {
					Text(
						text = "DXB",
						style = MaterialTheme.typography.titleLarge,
						color = Color.Black
					    )
					Spacer(modifier = Modifier.height(4.dp))
					Text(
						text = "Saturday",
						style = MaterialTheme.typography.bodySmall.copy(
							color = colorResource(id = R.color.app_gray))
					    )
					Text(
						text = "30 May 2021",
						style = MaterialTheme.typography.bodySmall.copy(
							color = colorResource(id = R.color.app_gray))
					    )
				}
				
				// Middle Section (Flight details)
				Box(
					modifier = Modifier
						.padding(horizontal = 16.dp)
						.clip(RoundedCornerShape(8.dp))
						.background(Color.White)
						.padding( vertical = 8.dp),
					contentAlignment = Alignment.Center
				   ) {
					Column(horizontalAlignment = Alignment.CenterHorizontally) {
						Text(
							text = "Fly Dubai",
							style = MaterialTheme.typography.bodyLarge,
							color = Color.Black
						    )
						Text(
							text = "B777 - EK225",
							style = MaterialTheme.typography.bodySmall,
							color = Color.Gray
						    )
						Spacer(modifier = Modifier.height(8.dp))
						Text(
							text = "1 KG Available",
							style = MaterialTheme.typography.bodyMedium,
							color = Color.Black,
							fontWeight = FontWeight.Bold
						    )
						Text(
							text = "15 hrs 50 mins",
							style = MaterialTheme.typography.bodySmall,
							color = Color.Gray
						    )
					}
				}
				
				// BLR Section
				Column(horizontalAlignment = Alignment.CenterHorizontally) {
					Text(
						text = "BLR",
						style = MaterialTheme.typography.titleLarge,
						color = Color.Black
					    )
					Spacer(modifier = Modifier.height(4.dp))
					Text(
						text = "Saturday",
						style = MaterialTheme.typography.bodySmall.copy(
							color = colorResource(id = R.color.app_gray))
					    )
					Text(
						text = "30 May 2021",
						style = MaterialTheme.typography.bodySmall.copy(
							color = colorResource(id = R.color.app_gray))
					    )
				}
			}
			
			Spacer(modifier = Modifier.height(16.dp))
			
			// Bottom Section
			Row(
				modifier = Modifier.fillMaxWidth(),
				verticalAlignment = Alignment.CenterVertically
			   ) {
				Image(
					painter = painterResource(id = R.drawable.timer_svg),
					contentDescription = null,
					
					
					modifier = Modifier.size(15.dp))
				Spacer(modifier = Modifier.width(8.dp))
				Text(
					"Pick up before 29 May 2021 at 10:00 pm",
					style = MaterialTheme.typography.bodySmall.copy(
						fontWeight = FontWeight.W500,
						fontSize = 9.sp,
						color = colorResource(id = R.color.app_gray)))
				
				Spacer(modifier = Modifier.weight(1f))
				
				// Favour Button
				Text(
					"Favour",
					
					style = MaterialTheme.typography.bodyMedium.copy(
						fontWeight = FontWeight.W500, fontSize = 10.sp, color = Color.White),
					
					modifier = Modifier
						.align(Alignment.Top)
						.background(
							color = colorResource(id = R.color.app_purple),
							shape = RoundedCornerShape(10.dp))
						.padding(horizontal = 8.dp, vertical = 4.dp)
				    
				    )
			}
		}
	}
}

@Preview
@Composable
fun PreviewFlightInfoCard() {
	TripInfoCard(selected = true)
}
