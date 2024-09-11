package com.example.travelapp.features.auth.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.travelapp.R
import com.example.travelapp.features.auth.presentation.HeaderLogo

@Composable
fun TopHeaderCurvedImage() {
	var painter = painterResource(id = R.drawable.curved_top_1)
	Box {
		Image(
			painter = painter, contentDescription = null, contentScale = ContentScale.Crop,
			
			modifier = Modifier.fillMaxWidth()
		     )
		
		HeaderLogo()
	}
}