package com.example.travelapp.features.find

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.travelapp.R
import com.example.travelapp.common.components.CommonAppBar
import com.example.travelapp.common.components.CommonYellowButton
import com.example.travelapp.common.components.ElevatedTextField
import com.example.travelapp.ui.theme.TravelAppTheme
import com.example.travelapp.ui.theme.raleWay

@Composable
fun FindAngels(navController: NavHostController) {
	
	Surface(
		color = Color.White,
		
		) {
		
		Scaffold(
			
			topBar = {
				CommonAppBar(title = "Find Angels")
			}) {
			Column(
				modifier = Modifier
					.padding(it)
					.padding(horizontal = 15.dp)
					.fillMaxWidth(),
				horizontalAlignment = Alignment.CenterHorizontally
			      
			      ) {
				
				Box(modifier = Modifier) {
					var painter = painterResource(id = R.drawable.angel_standing)
					Image(
						painter = painter,
						contentDescription = null,
						contentScale = ContentScale.FillHeight,
						
						modifier = Modifier
							.padding(bottom = 20.dp)
							.fillMaxWidth()
							.height(130.dp)
					     
					     
					     )
				}
				
				Text(
					"Find Your Angels",
					textAlign = TextAlign.Center,
					style = MaterialTheme.typography.titleLarge.copy(
						fontWeight = FontWeight.W300,
						
					                                                ),
					
					)
				
				Row(
					modifier = Modifier
						.padding(top = 20.dp)
						.fillMaxWidth(),
					
					horizontalArrangement = Arrangement.SpaceBetween
				   ) {
					ElevatedTextField(
						"From",
						icon = R.drawable.location_svg,
						modifier = Modifier
							.weight(1f)
							.padding(end = 5.dp)
					                 )
					ElevatedTextField(
						"To",
						icon = R.drawable.location_svg,
						modifier = Modifier
							.weight(1f)
							.padding(start = 5.dp)
					                 )
				}
				
				ElevatedTextField(
					"Date", icon = R.drawable.location_svg, modifier = Modifier
						
						.padding(top = 10.dp)
				                 )
				
				CommonYellowButton(
					text = "FIND YOUR ANGEL",
					onClick = { /*TODO*/ },
					modifier = Modifier
						.padding(top = 100.dp)
						.fillMaxWidth()
				                  )
				
				
			}
		}
	}
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun FindAngelsPreview() {
	TravelAppTheme {
		
		FindAngels(navController = rememberNavController())
		
		
	}
}
