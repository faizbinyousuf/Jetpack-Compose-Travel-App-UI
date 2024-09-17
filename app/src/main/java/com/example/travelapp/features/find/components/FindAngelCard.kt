package com.example.travelapp.features.find.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.travelapp.R
import com.example.travelapp.common.components.CardWithoutTonalElevation


@Composable
fun FindAngelCard(onClick: () -> Unit) {
	val gradient = Brush.linearGradient(
		colors = listOf(
			Color(0xFFF1F1F5), Color.Red))
	
	
	
	CardWithoutTonalElevation(
		elevation = 3.dp,
		modifier = Modifier.padding(horizontal = 15.dp, vertical = 10.dp)
			.clickable(onClick = onClick)
		
		,
		
		) {
		Row(
			verticalAlignment = Alignment.CenterVertically,
			modifier = Modifier
				.fillMaxWidth()
				.padding(top = 10.dp, bottom = 10.dp, start = 5.dp),
			
			) {
			var avatar = painterResource(id = R.drawable.home_header)
			Box(
				modifier = Modifier
					
					.padding(end = 10.dp)
					.height(85.dp)
					.width(85.dp)
					.padding(6.dp) // Define the box size, which matches the image size
					.background(Color.LightGray, CircleShape) // Apply red background in the circle
					.clip(CircleShape) // Clip the box itself as a circle
			   ) {
				Image(
					painter = avatar,
					contentDescription = null,
					contentScale = ContentScale.Crop, // Ensure image is cropped to fit the circle
					modifier = Modifier
						.fillMaxSize() // Fill the Box completely
						.clip(CircleShape) // Clip the image in a circle
				     )
			}
			
			Column(
				modifier = Modifier.weight(3f),
				verticalArrangement = Arrangement.spacedBy(6.dp),
				horizontalAlignment = Alignment.Start) {
				Text(
					"Faiz Yusuf", style = MaterialTheme.typography.bodyMedium.copy(
						fontWeight = FontWeight.W700))
				Row(
					verticalAlignment = Alignment.CenterVertically) {
					var weightIcon = painterResource(id = R.drawable.weight_svg)
					Icon(
						painter = weightIcon,
						contentDescription = null,
						tint = colorResource(id = R.color.app_yellow))
					Spacer(modifier = Modifier.width(5.dp))
					
					Text(
						"20Kg Available", style = MaterialTheme.typography.bodySmall.copy(
							color = colorResource(id = R.color.app_gray)))
					
					
				}
				Row {
					(1..5).forEach { index ->
						Image(
							painter = painterResource(id = R.drawable.rating_star_filled),
							contentDescription = null,
							
							colorFilter = ColorFilter.tint(colorResource(id = R.color.app_yellow)),
							modifier = Modifier.size(15.dp))
					}
				}
				Text(
					"ABC XYZ", style = MaterialTheme.typography.bodySmall.copy(
						fontWeight = FontWeight.W500))
				Text(
					"01 July 2024", style = MaterialTheme.typography.bodySmall.copy(
						fontWeight = FontWeight.W500,
						
						color = colorResource(id = R.color.app_gray)))
				
				Row(
					verticalAlignment = Alignment.CenterVertically,
					horizontalArrangement = Arrangement.spacedBy(5.dp)) {
					
					Image(
						painter = painterResource(id = R.drawable.timer_svg),
						contentDescription = null,
						
						
						modifier = Modifier.size(15.dp))
					Text(
						"Pick up before 29 May 2021 at 10:00 pm",
						style = MaterialTheme.typography.bodySmall.copy(
							fontWeight = FontWeight.W500,
							fontSize = 8.sp,
							color = colorResource(id = R.color.app_gray)))
					
					
				}
				
				
			}
			
			
			Text(
				"Favour",
				modifier = Modifier
					
					.weight(1f)
					.align(Alignment.Top)
					
					.height(20.dp)
					.background(
						color = colorResource(id = R.color.app_purple),
						shape = RoundedCornerShape(10.dp))
					.padding(horizontal = 8.dp, vertical = 4.dp),
				
				
				style = MaterialTheme.typography.bodyMedium.copy(
					fontWeight = FontWeight.W500, fontSize = 10.sp, color = Color.White),
				
				
				)
			
			Icon(
				painter = painterResource(id = R.drawable.green_arrow_svg),
				
				
				contentDescription = null,
				
				modifier = Modifier
					.offset(x = -10.dp)
					.size(13.dp)
			    
			    )
			
			
		}
	}
	
}
