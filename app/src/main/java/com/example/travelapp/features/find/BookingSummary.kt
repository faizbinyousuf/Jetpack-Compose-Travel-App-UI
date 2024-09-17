package com.example.travelapp.features.find

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.travelapp.R
import com.example.travelapp.common.components.CardWithoutTonalElevation
import com.example.travelapp.common.components.CommonAppBar
import com.example.travelapp.common.components.CommonYellowButton
import com.example.travelapp.features.find.components.TripInfoCard
import com.example.travelapp.ui.theme.TravelAppTheme

@Composable
fun BookingSummary(
	navController: NavHostController
				  ) {

	Surface (
		color = Color.White,
			){
		Scaffold(
			topBar = {
				
				var painter = painterResource(id = R.drawable.curved_top_2)
				
				Box(
					modifier = Modifier
						
						.background(color = Color.White)) {
					Image(
						painter = painter, contentDescription = null, contentScale = ContentScale.Crop,
						
						modifier = Modifier.fillMaxWidth())
					CommonAppBar(title = "Booking Summary")
					Box(
						modifier = Modifier
							.padding(horizontal = 20.dp)
							.align(
								Alignment.BottomCenter)
							.offset(y = (90).dp, x = 5.dp)
					   ) {
						TripInfoCard(selected = true)
					
					}
					
					
					
				}
			})
				 { it->
					
					Column(
						horizontalAlignment =  Alignment.CenterHorizontally,
						modifier = Modifier
							.padding(it)
							.padding(top = 100.dp, start = 15.dp, end = 15.dp)
							.fillMaxWidth()
						  ) {
						
						CardWithoutTonalElevation(
							elevation = 3.dp,
							gradientRequired = false,
							//border =  if(selected) BorderStroke(3.dp, color = colorResource(id = R.color.app_yellow)) else null,
							modifier = Modifier
								.padding(top = 20.dp, start = 12.dp, end = 12.dp)
								.fillMaxWidth(),
							shape = RoundedCornerShape(8.dp),
												 ){
							var textStyle = MaterialTheme.typography.bodyMedium.copy(
							                                                       
							                                                       )
							Column(
								modifier = Modifier
									.padding(12.dp)
									.fillMaxWidth()
								  ) {
								Text("Hey John Davis,\n" + "Could you please take my Luggage ?", style =textStyle)
								Spacer(modifier = Modifier .height(10.dp))
								Text(text = "Item Disscription\n" + "item Weight", style =textStyle)
								Spacer(modifier = Modifier .height(10.dp))
								Text(text = "Pickup Location\n" + "Drop Location", style =textStyle)
								Spacer(modifier = Modifier .height(10.dp))
								Text("Offer message", style =textStyle)
								
								
							}
							
						}
						Spacer(modifier =  Modifier .height(100.dp))
						
						CommonYellowButton(text = "SEND REQUEST", onClick = {
							navController.navigate("bookingConfirmation")
						})
					}
		}
	}

}

@Composable
@Preview
fun BookingSummaryPreview() {
	TravelAppTheme {
		BookingSummary(
			navController = rememberNavController()
					  )
	}

}