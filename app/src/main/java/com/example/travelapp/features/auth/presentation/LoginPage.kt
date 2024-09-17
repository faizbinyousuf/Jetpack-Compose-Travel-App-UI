package com.example.travelapp.features.auth.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.travelapp.R
import com.example.travelapp.common.components.CommonYellowButton
import com.example.travelapp.features.auth.components.CommonTextField
import com.example.travelapp.features.auth.components.TopHeaderCurvedImage
import com.example.travelapp.ui.theme.TravelAppTheme

@Composable
fun LoginScreen(navHostController: NavHostController) {
	
	Surface(
		color = Color.White,
		
		) {
		Column(
			horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize()
		      ) {
			TopHeaderCurvedImage()
			
			Column(
				horizontalAlignment = Alignment.CenterHorizontally,
				modifier = Modifier
					.fillMaxWidth()
					.padding(15.dp)
			      ) {
				Text("Sign In", style = MaterialTheme.typography.headlineMedium)
				Spacer(modifier = Modifier.height(15.dp))
				
				CommonTextField(label = "Mobile", value = "", onValueChange = {}
				               
				               )
				Spacer(modifier = Modifier.height(100.dp))
				
				CommonYellowButton(
					text = "SIGN IN", onClick = {
						navHostController.navigate("otpScreen")
					},
				                  )
				Spacer(modifier = Modifier.height(30.dp))
				SignUpText()
				
			}
		}
	}
}


@Composable
fun SignUpText() {
	val annotatedText = buildAnnotatedString {
		append("Don\'t have an Account? ")
		pushStringAnnotation(tag = "SIGN_UP", annotation = "sign_up")
		withStyle(
			style = MaterialTheme.typography.bodyMedium.toSpanStyle().copy(
				color = colorResource(id = R.color.app_yellow)
			                                                              )
		         ) {
			append("Sign Up")
		}
		pop()
	}
	
	ClickableText(
		text = annotatedText,
		onClick = { offset ->			// Detect if the "Sign In" part was clicked
			annotatedText.getStringAnnotations(tag = "SIGN_IN", start = offset, end = offset)
				.firstOrNull()?.let {					// Handle Sign In click
					println("Sign In clicked")
				}
		},
		style = TextStyle(color = Color.Gray, fontSize = 16.sp)
	             )
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginScreenPreview() {
	TravelAppTheme {
		LoginScreen(navHostController = rememberNavController())
	}
	
}