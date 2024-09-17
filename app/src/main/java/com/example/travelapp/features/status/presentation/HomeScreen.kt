package com.example.travelapp.features.status.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import com.example.travelapp.ui.theme.TravelAppTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController) {
	val scrollState = rememberScrollState()
	
	
	
	Scaffold(topBar = {
		CommonAppBar(showImage = true)
	}
	        
	        ) {
		Column(
			modifier = Modifier
				.padding(it)
				.padding(20.dp)
				.fillMaxSize()
				.verticalScroll(scrollState),
			
			horizontalAlignment = Alignment.Start) {
			TopImageSection()
			Text("Welcome".uppercase(), style = MaterialTheme.typography.titleMedium)
			Text(
				"Let\'s get started", style = MaterialTheme.typography.titleLarge)
			ActionItems()
			HowItWorksSection()
			CommonYellowButton(modifier = Modifier
				.fillMaxWidth()
				.padding(top = 15.dp, bottom = 30.dp),
				text = "GET STARED",
				onClick = {
					
				
				})
			
			
		}
	}
	
	
}

@Composable
fun HowItWorksSection() {
	var image = painterResource(id = R.drawable.how_it_works)
	Column(
		modifier = Modifier
			.padding(top = 15.dp)
			.fillMaxWidth()
	      
	      ) {
		Image(
			painter = image,
			contentDescription = "How it works",
			contentScale = ContentScale.Crop,
			modifier = Modifier.fillMaxWidth())
	}
	
	
}

@Composable
private fun ActionItems() {
	Row(
		horizontalArrangement = Arrangement.SpaceBetween,
		modifier = Modifier
			.padding(top = 20.dp)
			.fillMaxWidth()
	   
	   ) {
		
		ActionItemCard(
			icon = R.drawable.send_icon, text = "Send")
		ActionItemCard(
			icon = R.drawable.trip_icon, text = "Transport")
		ActionItemCard(
			icon = R.drawable.trusted_circle_icon, text = "Trusted Circle")
	}
}

@Composable
private fun ActionItemCard(icon: Int, text: String) {
	Card(
		shape = RoundedCornerShape(25.dp),
		modifier = Modifier
			.padding(0.dp)
			.height(130.dp)
			.width(100.dp)
			.padding(5.dp),
		colors = CardDefaults.cardColors(
			containerColor = colorResource(id = R.color.app_yellow))
	    
	    ) {
		
		Column(
			modifier = Modifier.fillMaxSize(),
			horizontalAlignment = Alignment.CenterHorizontally,
			verticalArrangement = Arrangement.Center) {
			var painter = painterResource(id = icon)
			Image(painter = painter, contentDescription = null)
			Spacer(modifier = Modifier.height(12.dp))
			Text(
				
				text,
				style = MaterialTheme.typography.bodyMedium.copy(
					fontWeight = FontWeight.W500, fontSize = 11.sp),
				textAlign = TextAlign.Center,
			    )
			
		}
	}
}

@Composable
private fun TopImageSection() {
	var image = painterResource(id = R.drawable.home_header)
	
	Image(
		painter = image, contentDescription = null, contentScale = ContentScale.FillWidth,
		
		modifier = Modifier
			.padding(top = 15.dp)
			.fillMaxWidth()
			.height(280.dp))
}

@Preview
@Composable
fun HomeScreenPreview() {
	TravelAppTheme {
		HomeScreen(navController = rememberNavController())
	}
	
}