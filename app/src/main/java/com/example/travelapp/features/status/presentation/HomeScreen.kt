package com.example.travelapp.features.status.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
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
import com.example.travelapp.common.ListTile
import com.example.travelapp.common.components.CommonAppBar
import com.example.travelapp.common.components.CommonYellowButton
import com.example.travelapp.features.status.components.ExoPlayerComposable
import com.example.travelapp.ui.theme.TravelAppTheme
import kotlinx.coroutines.launch
import java.net.URLEncoder
import java.nio.charset.StandardCharsets


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController) {
	val scrollState = rememberScrollState()

	val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
	val scope = rememberCoroutineScope()



	ModalNavigationDrawer(



		drawerState = drawerState,
		drawerContent = {

			Box(
				modifier = Modifier
					.fillMaxHeight()
					.width(300.dp)
					.background(Color.White)
			) {
				Column(
					modifier = Modifier.padding(16.dp)
				) {
					var painter = painterResource(id = R.drawable.logo_header_home)

					Image(
						painter = painter, contentDescription = null, contentScale = ContentScale.FillHeight,

						modifier = Modifier
						.fillMaxWidth()
							.height(85.dp)
					)
					Spacer(modifier = Modifier.height(60.dp))

					ListTile(
						title = "Charts",

						onClick = {
							scope.launch{
								drawerState.close()
							}
							navController.navigate("charts")
						}
					)

					ListTile(
						title = "Web View",
						onClick = {
							scope.launch{
								drawerState.close()
							}
							val url  = "https://www.youtube.com"
							val encodedUrl = URLEncoder.encode(url, StandardCharsets.UTF_8.toString())
							navController.navigate("webview/$encodedUrl")
						}
					)

					ListTile(
						title = "Download Manager",

						onClick = {
							scope.launch{
								drawerState.close()
							}
							navController.navigate("download")
						}
					)

					Spacer(modifier = Modifier.height(10.dp))

				}
			}
			},
	) {
		Scaffold(
			contentWindowInsets = WindowInsets(0.dp),
			topBar = {
				CommonAppBar(navController = navController, showImage = true,

					onNavigationIconClick = {
						scope.launch {
							if (drawerState.isOpen) {
								drawerState.close()
							} else {
								drawerState.open()
							}
						}
					}
				)
			}

		) { innerPadding ->
			Column(
				modifier = Modifier
					.padding(innerPadding)
					.padding(start = 15.dp, end = 15.dp, top = 15.dp, bottom = 0.dp)
					.fillMaxSize()
					.verticalScroll(scrollState),

				horizontalAlignment = Alignment.Start
			) {
				TopImageSection()
				Text("Welcome".uppercase(), style = MaterialTheme.typography.titleMedium)
				Text(
					"Let\'s get started", style = MaterialTheme.typography.titleLarge
				)
				ActionItems()
				HowItWorksSection()
				CommonYellowButton(modifier = Modifier
					.fillMaxWidth()
					.padding(top = 15.dp, bottom = 30.dp),
					text = "GET STARTED",
					onClick = {


					})


			}
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
			.height(200.dp)
			.background(
				color = Color.Gray, shape = RoundedCornerShape(25.dp)
			)
			.clip(RoundedCornerShape(25.dp))
	      
	      ) {
		//Text("dsd")

		ExoPlayerComposable()



//		Image(
//			painter = image,
//			contentDescription = "How it works",
//			contentScale = ContentScale.Crop,
//			modifier = Modifier.fillMaxWidth())
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