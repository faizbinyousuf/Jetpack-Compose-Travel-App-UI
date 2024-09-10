package com.example.travelapp.features.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.travelapp.R
import com.example.travelapp.ui.theme.TravelAppTheme

@Composable
fun AuthWrapper(navHostController: NavHostController) {
	
	Scaffold(
		containerColor = colorResource(id = R.color.app_yellow)
	        ) { it ->
		Column(
			modifier = Modifier
				.fillMaxWidth()
				.padding(it)
		      ) {
			
			HeaderLogo()
			OnboardImage()
			Text(
				"Send with ease",
				style = MaterialTheme.typography.headlineMedium,
				textAlign = TextAlign.Center,
				modifier = Modifier
					.padding(top = 20.dp)
					.fillMaxWidth()
					.align(Alignment.CenterHorizontally)
			    )
			Spacer(modifier = Modifier.weight(1f))
			BottomOptions(onNavigateLogin = { navHostController.navigate("login") },
				onNavigateSignUp = { navHostController.navigate("signup") })
			
		}
	}
	
}

@Composable
fun BottomOptions(onNavigateLogin: () -> Unit, onNavigateSignUp: () -> Unit) {
	Row(
		horizontalArrangement = Arrangement.SpaceAround,
		verticalAlignment = Alignment.CenterVertically,
		modifier = Modifier
			.fillMaxWidth() //			.background(color = Color.Magenta)
			.height(80.dp)
	   ) {
		Text(text = "Sign In",
			style = MaterialTheme.typography.bodyMedium,
			modifier = Modifier
				.clickable() {
					onNavigateLogin()
				}
				.padding(15.dp))
		Text(text = "Create Account",
			style = MaterialTheme.typography.bodyMedium,
			modifier = Modifier
				.clickable() {
					onNavigateSignUp()
				}
				.padding(15.dp))
	}
}

@Composable
fun HeaderLogo() {
	var painter = painterResource(id = R.drawable.logo_valeeze_png)
	Image(
		painter = painter, contentDescription = null,
		
		modifier = Modifier
			.padding(top = 60.dp)
			.height(150.dp)
			.fillMaxWidth()
	     )
}

@Composable
fun OnboardImage() {
	var painter = painterResource(id = R.drawable.onboard_image)
	Image(
		painter = painter, contentDescription = null,
		
		modifier = Modifier
			.padding(top = 50.dp)
			.height(150.dp)
			.fillMaxWidth()
	     )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AuthWrapperPreview() {
	TravelAppTheme {
		AuthWrapper(navHostController = rememberNavController())
	}
	
}


