import android.annotation.SuppressLint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.geometry.Offset

import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.travelapp.R

@Composable
fun StepsProgressBar(modifier: Modifier = Modifier, numberOfSteps: Int, currentStep: Int) {
	Row(
		modifier = modifier,
		verticalAlignment = Alignment.CenterVertically
	   ) {
		for (step in 0..numberOfSteps) {
			Step(
				modifier = Modifier.weight(1F),
				isCompete = step < currentStep,
				isCurrent = step == currentStep
			    )
		}
	}
}

@Composable
fun Step(modifier: Modifier = Modifier, isCompete: Boolean, isCurrent: Boolean) {
	var yellowColor = colorResource(id = R.color.app_yellow)
	var appGrey = colorResource(id = R.color.app_gray)
	val color = if (isCompete || isCurrent) yellowColor else appGrey
	val innerCircleColor = if (isCompete) yellowColor else appGrey
	
	Box(modifier = modifier) {
		
		//Line
		Divider(
			modifier = Modifier.align(Alignment.CenterStart)
				.clip(RoundedCornerShape(12.dp))
			
				
				//.clip(RoundedCornerShape(12.dp))
			,
			color = color,
			thickness = 12.dp
		       )
		
		
		//Circle
		Canvas(modifier = Modifier
			.size (15.dp)
			.align(Alignment.CenterEnd)
			.border(
				shape = CircleShape,
				width = 2.dp,
				color = Color.LightGray
			       )
			.offset(x = 6.dp)
			
			,
			onDraw = {
				drawCircle(color = innerCircleColor)
			}
		      )
	}
}

@SuppressLint("RememberReturnType")
@Preview
@Composable
fun StepsProgressBarPreview() {
	val currentStep = remember { mutableStateOf(1) }
	StepsProgressBar(modifier = Modifier.fillMaxWidth(), numberOfSteps = 5, currentStep = currentStep.value)
}