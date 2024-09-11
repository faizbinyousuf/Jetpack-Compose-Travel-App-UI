package com.example.travelapp.features.auth.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

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

