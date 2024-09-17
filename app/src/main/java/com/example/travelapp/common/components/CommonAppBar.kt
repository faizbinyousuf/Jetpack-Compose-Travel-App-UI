package com.example.travelapp.common.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.travelapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CommonAppBar(showImage: Boolean = false, title: String = "") {
	CenterAlignedTopAppBar(
		
		colors = TopAppBarDefaults.topAppBarColors(
			containerColor = Color.Transparent),
		
		modifier = Modifier
			
			.padding(horizontal = 15.dp),
//			.height(64.dp),
		
		title = {
			if (showImage) {
				var painter = painterResource(id = R.drawable.logo_header_home)
				
				Image(
					painter = painter, contentDescription = null, contentScale = ContentScale.Fit,
					
					modifier = Modifier
						.width(120.dp)
						.height(60.dp)
					 )
			}
			else {
				Text(text = title, style = MaterialTheme.typography.titleSmall)
			}
			
			
		}, navigationIcon = {
			if (!showImage) {
				var svgIcon = painterResource(id = R.drawable.back_arrow_svg)
				Image(painter = svgIcon, contentDescription = null)
				
			}
			
		}, actions = {
			var painter = painterResource(id = R.drawable.menu_icon_png)
			
			Image(
				painter = painter, contentDescription = null, contentScale = ContentScale.Fit,
				
				modifier = Modifier
					.width(25.dp)
					.height(25.dp))
		})
}