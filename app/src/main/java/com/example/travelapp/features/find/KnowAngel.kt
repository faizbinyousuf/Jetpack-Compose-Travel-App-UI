package com.example.travelapp.features.find

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.travelapp.R
import com.example.travelapp.common.components.CommonAppBar
import com.example.travelapp.common.components.CommonYellowButton
import com.example.travelapp.features.find.components.TripInfoCard
import com.example.travelapp.ui.theme.TravelAppTheme

@Composable
fun KnowAngel(
	navController: NavHostController
			 ) {
	var isSelectedTrip by remember { mutableStateOf(false) }
	var isSelectedUpComing by remember { mutableStateOf(false) }
	Surface(
		color = Color.White,
		
		
		) {
		
		Scaffold(
			topBar = {
			
			var painter = painterResource(id = R.drawable.curved_top_2)
			
			Box(
				modifier = Modifier
					
					.background(color = Color.White)) {
				Image(
					painter = painter, contentDescription = null, contentScale = ContentScale.Crop,
					
					modifier = Modifier.fillMaxWidth())
				CommonAppBar(title = "Know your ")
				ProfileImageSection(
					modifier = Modifier
						
						.align(
							Alignment.BottomCenter)
						.offset(y = (50).dp, x = 5.dp)
				                   
				                   )
				
			}
		})
		
		{
			val scrollState = rememberScrollState()
			Column(
				modifier = Modifier.verticalScroll(scrollState)) {
				Column(
					modifier = Modifier
						.padding(it)
						.padding(
							horizontal = 15.dp)
						.fillMaxWidth()
						.background(
							color = Color.White)
						
					,
					horizontalAlignment = Alignment.CenterHorizontally) {
					
					
					Text(
						"John Davis",
						style = MaterialTheme.typography.titleMedium.copy(
							fontSize = 16.sp, fontWeight = FontWeight.W700
						                                                 
						                                                 ),
						modifier = Modifier.padding(top = 50.dp))
					Spacer(modifier = Modifier.height(10.dp))
					Text(
						"What is Lorem Ipsum Lorem Ipsum is simply dummy text of the printing and typesetting industry  View More",
						style = MaterialTheme.typography.bodyMedium.copy(
							color = colorResource(id = R.color.app_gray)),
						lineHeight = 18.sp,
						textAlign = TextAlign.Center
					    
					    )
					
					
					Row(
						verticalAlignment = Alignment.CenterVertically,
						horizontalArrangement = Arrangement.Start,
						modifier = Modifier
							.padding(top = 30.dp, bottom = 15.dp)
							.fillMaxWidth()) {
						
						Text(
							"4/5",
							style = MaterialTheme.typography.bodyMedium.copy(
								fontSize = 14.sp, fontWeight = FontWeight.W700
							                                                
							                                                ),
							modifier = Modifier.padding(end = 10.dp)
						    
						    )
						
						
						(1..5).forEach { index ->
							Image(
								painter = painterResource(id = R.drawable.rating_star_filled),
								contentDescription = null,
								
								colorFilter = ColorFilter.tint(colorResource(id = R.color.app_yellow)),
								modifier = Modifier.size(15.dp))
						}
						
						Spacer(modifier = Modifier.weight(1f))
						
						Row(
							verticalAlignment = Alignment.CenterVertically,
							
							) {
							var painter = painterResource(id = R.drawable.add_icon)
							Image(
								painter = painter, contentDescription = null,
								
								modifier = Modifier
									.padding(start = 10.dp, end = 8.dp)
									.size(20.dp))
							Text(
								"ADD TO TRUSTED\nCIRCLE",
								style = MaterialTheme.typography.bodyMedium.copy(
									fontWeight = FontWeight.W500,
									color = colorResource(id = R.color.app_gray)))
						}
						
					}
					
				}
				
				
				
				
				
				
				Surface(
					color =
					Color(0xFFF5F5F5),
					modifier = Modifier
						
						.fillMaxWidth()
						.offset(y = -30.dp)
					   ) {
					Column(
						horizontalAlignment = Alignment.CenterHorizontally,
						modifier = Modifier.padding(15.dp)) {
						Text(
							text = "Selected Trip",
							
							style = MaterialTheme.typography.titleLarge.copy(
								fontWeight = FontWeight.W300
							                                                
							                                                )
						    
						    )
						TripInfoCard(selected = isSelectedTrip, onClick = {
							
							isSelectedTrip = !isSelectedTrip
						})
						Spacer(modifier = Modifier.height(10.dp))
						Text(
							text = "Upcoming Trip",
							
							style = MaterialTheme.typography.titleLarge.copy(
								fontWeight = FontWeight.W300
							                                                
							                                                )
						    
						    )
						TripInfoCard(selected = isSelectedUpComing, onClick = {
							isSelectedUpComing = !isSelectedUpComing
						})
						Spacer(modifier = Modifier.height(20.dp))
						CommonYellowButton(text = "CONTINUE", onClick = {
							
							navController.navigate("bookingSummary")
						})
						Spacer(modifier = Modifier.height(60.dp))
					}
				}
			}
		}
	}
	
}

@Composable
fun ProfileImageSection(modifier: Modifier = Modifier) {
	var avatar = painterResource(id = R.drawable.home_header)
	Box(
		modifier = modifier
			.padding(end = 10.dp)
			.height(120.dp)
			.width(120.dp)
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
	
	
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun KnowAngelPreview() {
	TravelAppTheme {
		KnowAngel(
			navController = rememberNavController(),
				 )
	}
	
}