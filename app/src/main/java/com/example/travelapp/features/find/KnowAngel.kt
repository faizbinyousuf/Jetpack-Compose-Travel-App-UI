package com.example.travelapp.features.find

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.travelapp.common.components.CommonAppBar
import com.example.travelapp.ui.theme.TravelAppTheme

@Composable
fun KnowAngel() {
	Surface(
		color = Color.White,
		
		   ) {
		Scaffold(
			topBar = {
				CommonAppBar(title = "Know your Buddy")
			}
				) {
			Column(
				modifier = Modifier
					.padding(it)
					.fillMaxSize(),
				horizontalAlignment = Alignment.CenterHorizontally
				  ) {
				
				Box(
					modifier = Modifier.
				   
				   ){
					
				}
				
			}
		}
	}

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun KnowAngelPreview() {
	TravelAppTheme {
		KnowAngel()
	}
	
}