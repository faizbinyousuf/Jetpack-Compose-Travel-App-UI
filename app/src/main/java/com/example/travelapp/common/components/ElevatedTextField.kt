package com.example.travelapp.common.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ElevatedTextField(label: String = "Enter text here", icon: Int, modifier: Modifier = Modifier) {
	var text by remember { mutableStateOf(TextFieldValue("")) }
	
	TextField(
		value = text,
		onValueChange = { text = it },
		modifier = modifier
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
		placeholder = {
			Text(text = label, style = MaterialTheme.typography.bodyMedium)
		},
		trailingIcon = {
			
			Icon(
				painter = painterResource(id = icon),
				contentDescription = "send",
				modifier = Modifier //						.align(Alignment.TopEnd) // Align to the top right corner
					.padding(8.dp)
					.size(22.dp)
			    )
			
		}
	         
	         )
}