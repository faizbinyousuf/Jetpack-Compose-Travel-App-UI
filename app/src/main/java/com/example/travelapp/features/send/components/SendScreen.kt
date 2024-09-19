package com.example.travelapp.features.send.components

import android.annotation.SuppressLint
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.travelapp.R
import com.example.travelapp.common.components.CommonAppBar
import com.example.travelapp.common.components.CommonYellowButton
import com.example.travelapp.common.components.ElevatedTextField
import com.example.travelapp.ui.theme.TravelAppTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SendScreen(
	navController: NavHostController
              ) {
	var context = LocalContext.current
	var scrollState = rememberScrollState()
	
	
	BackHandler {
		navController.navigate("mainScreen"){
			popUpTo(0) { inclusive = true }
			launchSingleTop = true
		}
	}
	
	Surface(
		color = Color.White
	       ) {
		Scaffold(
			contentWindowInsets = WindowInsets(0.dp),
			topBar = {
			CommonAppBar(   navController = navController,title = "Send")
		}) {
			Column(
				modifier = Modifier
					.fillMaxWidth()
					.padding(it)
					.padding(horizontal = 15.dp)
					.verticalScroll(scrollState)
				,
				horizontalAlignment = Alignment.CenterHorizontally,
				verticalArrangement = Arrangement.spacedBy(12.dp)
			      ) {


				Text(
					"What are you sending?",

					style = MaterialTheme.typography.titleLarge.copy(
						fontWeight = FontWeight.W300
					                                                ),

					)
				BoxImage()
					ItemDropDown()
				
				ItemImageContainer()
				

				ItemDescriptionTextField("Item Description")
				ElevatedTextField(
					"Approximate value in $", icon = R.drawable.dollar_svg
				                 )
				ElevatedTextField(
					"Approximate weight in KG", icon = R.drawable.weight_svg
				                 )
				Row(
					modifier = Modifier
						.fillMaxWidth(),

					horizontalArrangement = Arrangement.SpaceBetween
				   ) {
					ElevatedTextField(
						"From", icon = R.drawable.location_svg,
						modifier = Modifier
							.weight(1f)
							.padding(end = 5.dp)
					                 )
					ElevatedTextField(
						"To", icon = R.drawable.location_svg, modifier = Modifier
							.weight(1f)
							.padding(start = 5.dp)
					                 )

					ItemDescriptionTextField("Make an offer to find Angels faster ")
				}

				CommonYellowButton(
					text = "DONE", onClick = {
						navController.navigate("findAngels")
					},

					modifier = Modifier.
					padding(top = 15.dp, bottom = 30.dp).
					fillMaxWidth()



								  )





			}
		}
	}
	
}


@Composable
fun ItemDescriptionTextField(label: String) {
	var text by remember { mutableStateOf(TextFieldValue("")) }
	
	TextField(value = text, maxLines = 5, minLines = 3,
		
		
		trailingIcon = {
			Box(
				modifier = Modifier.offset(y = (-20).dp)
			   
			   
			   ) {
				Icon(
					painter = painterResource(id = R.drawable.description_svg),
					contentDescription = "send",
					modifier = Modifier
						.align(Alignment.TopEnd) // Align to the top right corner
						.padding(8.dp)
						.size(22.dp)
				    )
			}
		}, onValueChange = { text = it }, modifier = Modifier
			.fillMaxWidth() //			.padding(10.dp)
			.shadow(
				elevation = 2.dp, // Set elevation here
				shape = RoundedCornerShape(8.dp),
				clip = true // Ensure the shadow is clipped to the shape
			       )
			.background(
				color = Color.White, shape = RoundedCornerShape(8.dp)
			           )
			.border(width = 1.dp, color = Color(0xFFCDC9C9), shape = RoundedCornerShape(8.dp)),
		
		shape = RoundedCornerShape(8.dp), colors = TextFieldDefaults.colors(
			focusedContainerColor = Color.Transparent,
			unfocusedContainerColor = Color.Transparent,
			disabledContainerColor = Color.Transparent,
			focusedIndicatorColor = Color.Transparent, // Remove default underline
			unfocusedIndicatorColor = Color.Transparent,
		                                                                   ), placeholder = {
			Text(text = label)
		})
	
}

@Composable
fun ItemImageContainer() {
	
	Box(
		contentAlignment = Alignment.Center, modifier = Modifier //			.padding(horizontal = 10.dp)
			
			.height(150.dp)
			
			//.padding(10.dp)
			.border(width = 1.dp, color = Color(0xFFCDC9C9), shape = RoundedCornerShape(8.dp))
			.fillMaxWidth()
			.background(color = Color.White)
	   ) {
		Column(
			horizontalAlignment = Alignment.CenterHorizontally,
			modifier = Modifier
				.fillMaxWidth()
				.padding(10.dp)
		      
		      ) {
			Image(
				painter = painterResource(id = R.drawable.camera_icon),
				contentDescription = "Send",
				contentScale = ContentScale.Fit,
				colorFilter = ColorFilter.tint(colorResource(id = R.color.app_yellow)),
			     )
			Spacer(modifier = Modifier.height(10.dp))
			
			Text("Take a photo of your item", style = MaterialTheme.typography.bodyMedium)
		}
	}
	
	
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ItemDropDown() {
	val options = listOf("Option 1", "Option 2", "Option 3", "Option 4", "Option 5")
	var expanded by remember { mutableStateOf(false) }
	var selectedOptionText by remember { mutableStateOf(options[0]) }

	ExposedDropdownMenuBox(
		expanded = expanded,
		onExpandedChange = {
			expanded = !expanded
		}
	) {


		TextField(
			readOnly = true,
			value = selectedOptionText,
			onValueChange = { },
			modifier = Modifier
				.menuAnchor()
				.fillMaxWidth() //			.padding(10.dp)
				.shadow(
					elevation = 2.dp, // Set elevation here
					shape = RoundedCornerShape(8.dp),
					clip = true // Ensure the shadow is clipped to the shape
				)
				.background(
					color = Color.White, shape = RoundedCornerShape(8.dp)
				)
				.border(width = 1.dp, color = Color(0xFFCDC9C9), shape = RoundedCornerShape(8.dp)),

			shape = RoundedCornerShape(8.dp),
			colors = TextFieldDefaults.colors(
				focusedContainerColor = Color.Transparent,
				unfocusedContainerColor = Color.Transparent,
				disabledContainerColor = Color.Transparent,
				focusedIndicatorColor = Color.Transparent, // Remove default underline
				unfocusedIndicatorColor = Color.Transparent,
			),

						trailingIcon = {
				ExposedDropdownMenuDefaults.TrailingIcon(
					expanded = expanded
				)
			},

		)
//
//		TextField(
//			modifier = Modifier.menuAnchor()
//,			readOnly = true,
//			value = selectedOptionText,
//			onValueChange = { },
//			label = { Text("Label") },
//			trailingIcon = {
//				ExposedDropdownMenuDefaults.TrailingIcon(
//					expanded = expanded
//				)
//			},
//			colors = ExposedDropdownMenuDefaults.textFieldColors()
//		)
		ExposedDropdownMenu(
			expanded = expanded,
			onDismissRequest = {
				expanded = false
			}
		) {
			options.forEach { selectionOption ->
				DropdownMenuItem(
					text = {Text(text = selectionOption)},
					onClick = {
						selectedOptionText = selectionOption
						expanded = false
					}
				)


			}
		}
	}
}



@Composable
private fun BoxImage() {
	var carTonBox = painterResource(id = R.drawable.carton_box)
	
	Image(
		painter = carTonBox,
		contentDescription = null,
		contentScale = ContentScale.Fit,
		modifier = Modifier
			.padding(20.dp)
			.fillMaxWidth()
			.height(120.dp)
	     )
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SendScreenPreview() {
	TravelAppTheme {
		SendScreen(navController = rememberNavController())
	}
}