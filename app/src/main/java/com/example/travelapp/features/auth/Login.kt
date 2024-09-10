package com.example.travelapp.features.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.travelapp.R
import com.example.travelapp.common.components.CommonYellowButton
import com.example.travelapp.ui.theme.TravelAppTheme

@Composable
fun LoginScreen() {
	
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
				Text("Register", style = MaterialTheme.typography.headlineMedium)
				Spacer(modifier = Modifier.height(15.dp))
				CommonTextField(label = "Name", value = "", onValueChange = {}
				               
				               )
				Spacer(modifier = Modifier.height(10.dp))
				CommonTextField(label = "Mobile", value = "", onValueChange = {}
				               
				               )
				Spacer(modifier = Modifier.height(30.dp))
				
				CommonYellowButton(
					text = "SIGN UP", onClick = {},
				                  )
				Spacer(modifier = Modifier.height(30.dp))
				SignInText()
				
			}
		}
	}
}


@Composable
fun SignInText() {
	val annotatedText = buildAnnotatedString {
		append("Have an Account? ")
		pushStringAnnotation(tag = "SIGN_IN", annotation = "sign_in")
		withStyle(
			style = MaterialTheme.typography.bodyMedium.toSpanStyle().copy(
				color = colorResource(id = R.color.app_yellow)
			                                                              )
		         ) {
			append("Sign In")
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


@Composable
fun CommonTextField(label: String, value: String, onValueChange: (String) -> Unit) {
	TextField(
		value = value,
		colors = TextFieldDefaults.colors(
			focusedIndicatorColor = Color.Transparent,
			unfocusedIndicatorColor = Color.Transparent,
			disabledIndicatorColor = Color.Transparent,
			unfocusedContainerColor = Color.White,
			focusedContainerColor = Color.White,
			
			),
		
		shape = RoundedCornerShape(10.dp),
		onValueChange = { },
		label = { Text(label, style = MaterialTheme.typography.bodyMedium) },
		modifier = Modifier
			.fillMaxWidth()
			.padding(horizontal = 16.dp)
			
			
			.border(
				width = 1.dp, color = Color(0xFFCDC9C9), shape = RoundedCornerShape(10.dp)
			       )
			.shadow(
				elevation = 4.dp, ambientColor = Color(0xFFCDC9C9), spotColor = Color(0xFFCDC9C9)
			       )
	         )
	
}

@Composable
fun TopHeaderCurvedImage() {
	var painter = painterResource(id = R.drawable.curved_top_1)
	Image(
		painter = painter, contentDescription = null, contentScale = ContentScale.Crop,
		
		modifier = Modifier.fillMaxWidth()
		 )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginScreenPreview() {
	TravelAppTheme {
		LoginScreen()
	}
	
}