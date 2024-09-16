package com.example.travelapp.common.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


@Composable
fun CardWithoutTonalElevation(
	modifier: Modifier = Modifier,
	shape: Shape = CardDefaults.shape,
	colors: Color = Color.White,
	border: BorderStroke? = null,
	elevation: Dp = 0.dp,
	gradientRequired: Boolean = true,
	content: @Composable ColumnScope.() -> Unit = {}
                             )  {
	val gradient = Brush.linearGradient(
		colors = listOf(
			Color(0xFFF1F1F5), Color.Red))
	
	val gradient2 = Brush.linearGradient(
		colors = listOf(
			Color(0xFFF1F1F5), // Light gray or light purple on the left side
			Color.White // White on the right side
		               ),
		start = Offset(0f, 0f), // Start at the left
		end = Offset(Float.POSITIVE_INFINITY, 0f) // End at the right
	                                    )
	
	Surface(
		modifier = modifier,
		shape = shape,
		color = colors,
		tonalElevation = 0.dp,
		shadowElevation = elevation,
		border = border,
	       ) {
		Column(content = content,   modifier =  if (gradientRequired)   Modifier.background( gradient2) else modifier, )
	}
}