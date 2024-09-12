package com.example.travelapp.features.find

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.travelapp.R
import com.example.travelapp.common.components.CommonAppBar
import com.example.travelapp.features.find.components.FindAngelCard
import com.example.travelapp.ui.theme.TravelAppTheme

@Composable
fun AngelListingScreen() {
	
	Surface(
		color = Color.White) {
		Scaffold(topBar = {
			CommonAppBar(
				title = "My Angels")
		}) {
			Column(
				modifier = Modifier
					.padding(it)
					.fillMaxSize(), horizontalAlignment = Alignment.Start
			      
			      ) {
				FilterSection()
				CustomLineWithCircles()
				StartAndDestination()
			    LazyColumn {
					items(3) {
						FindAngelCard()
					}
			    }
				
			}
		}
	}
	
}

@Composable
private fun StartAndDestination() {
	Row(
		modifier = Modifier
			.padding(start = 15.dp, end = 15.dp, top = 20.dp, bottom = 20.dp)
			.fillMaxWidth(),
		verticalAlignment = Alignment.CenterVertically,
		horizontalArrangement = Arrangement.SpaceBetween) {
		Column {
			Text("ABC", style = MaterialTheme.typography.titleLarge)
			Text(
				"Saturday", style = MaterialTheme.typography.bodySmall.copy(
					color = colorResource(id = R.color.app_gray)))
			Text(
				"30 May 2024", style = MaterialTheme.typography.bodySmall.copy(
					color = colorResource(id = R.color.app_gray)))
		}
		Column {
			Text("XYZ", style = MaterialTheme.typography.titleLarge)
			Text(
				"Saturday", style = MaterialTheme.typography.bodySmall.copy(
					color = colorResource(id = R.color.app_gray)))
			Text(
				"30 May 2024", style = MaterialTheme.typography.bodySmall.copy(
					color = colorResource(id = R.color.app_gray)))
		}
	}
}


@Composable
fun CustomLineWithCircles() {    // Define your line thickness and circle size
	val lineThickness = 5.dp
	val circleSize = 16.dp
	
	Box(modifier = Modifier.fillMaxWidth()) {
		Canvas(
			modifier = Modifier
				.padding(top = 10.dp)
				.fillMaxWidth()
				.height(lineThickness)
				.padding(horizontal = 16.dp)) {            // Draw the line
			val startX = circleSize.toPx() / 2 // Adjusted to account for the circle's radius
			val endX = size.width - (circleSize.toPx() / 2)
			val centerY = size.height / 2
			
			// Line between circles
			drawLine(
				color = Color(0XFFFCD80E),
				start = Offset(startX, centerY),
				end = Offset(endX, centerY),
				strokeWidth = lineThickness.toPx(),
				cap = StrokeCap.Round)
			
			// Draw left circle
			drawCircle(
				color = Color(0XFFFCD80E),
				radius = circleSize.toPx() / 2,
				center = Offset(startX, centerY))
			
			// Draw right circle
			drawCircle(
				color = Color(0XFFFCD80E),
				radius = circleSize.toPx() / 2,
				center = Offset(endX, centerY))
		}
	}
}

@Composable
private fun FilterSection() {
	Row(
		modifier = Modifier
			.padding(end = 15.dp)
			.fillMaxWidth(),
		verticalAlignment = Alignment.CenterVertically,
		horizontalArrangement = Arrangement.SpaceBetween) {
		Text(
			text = "23  Available", style = MaterialTheme.typography.titleMedium,
			
			modifier = Modifier.padding(20.dp))
		
		OutlinedButton(colors = ButtonDefaults.buttonColors(
			contentColor = Color.Black, containerColor = Color.White),
			modifier = Modifier
				.height(33.dp)
				.padding(vertical = 1.dp, horizontal = 3.dp),
			
			shape = RoundedCornerShape(6.dp),
			onClick = { /*TODO*/ }) {
			Text(
				"Filter", style = MaterialTheme.typography.labelSmall)
		}
	}
}


@Preview
@Composable
fun AngelListingScreenPreview() {
	
	TravelAppTheme {
		AngelListingScreen()
	}
	
}


@Composable
fun CardWithoutTonalElevation(
	modifier: Modifier = Modifier,
	shape: Shape = CardDefaults.shape,
	colors: Color = White,
	border: BorderStroke? = null,
	elevation: Dp = 0.dp,
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
		Column(content = content, modifier = Modifier.background(gradient2),)
	}
}