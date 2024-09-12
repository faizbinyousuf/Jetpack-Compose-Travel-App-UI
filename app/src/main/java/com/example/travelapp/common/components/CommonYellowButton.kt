package com.example.travelapp.common.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.travelapp.R
import com.example.travelapp.ui.theme.buttonLabelStyle

@Composable
fun CommonYellowButton(
	text: String,
	onClick: () -> Unit,
	modifier: Modifier = Modifier,
	width: Int = 300
                      ) {
	Button(
		onClick = { onClick() },
		shape = RoundedCornerShape(30.dp),
		colors = ButtonDefaults.buttonColors(
			containerColor = colorResource(id = R.color.app_yellow)),
		modifier = modifier
			.shadow(
				elevation = 6.dp,  // Equivalent to the shadow height
				shape = RoundedCornerShape(30.dp), // Use same shape as the button
				clip = false)
			.height(48.dp)
			.width(width.dp),
		
		) {
		Text(
			text = text, color = colorResource(id = R.color.black), style = buttonLabelStyle)
	}
}

