package com.example.travelapp.common.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.travelapp.R
import com.example.travelapp.ui.theme.buttonLabelStyle

@Composable
fun AddTripLuggageButton(label:String) {
	Button(
		onClick = {},
		shape = RoundedCornerShape(20.dp),
		colors = ButtonDefaults.buttonColors(
			containerColor = colorResource(id = R.color.app_yellow)),
		modifier = Modifier.padding(top = 10.dp).shadow(
				elevation = 6.dp,  // Equivalent to the shadow height
				shape = RoundedCornerShape(20.dp), // Use same shape as the button
				clip = false).height(75.dp).fillMaxWidth(),
		
		
		) {
		
		Icon(
			painter = painterResource(id = R.drawable.add_icon),
			contentDescription = null,
			tint = colorResource(id = R.color.black),
			modifier = Modifier.padding(end = 20.dp))
		
		
		Text(label, color = colorResource(id = R.color.black), style = buttonLabelStyle)
	}
}