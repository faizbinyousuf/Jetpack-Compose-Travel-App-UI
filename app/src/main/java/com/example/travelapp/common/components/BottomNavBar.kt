package com.example.travelapp.common.components

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable

import androidx.compose.ui.unit.dp

import androidx.compose.foundation.Image
import androidx.compose.foundation.Indication
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.travelapp.R


@Composable
fun CustomBottomNavigation( selectedIndex: Int,  onItemSelected : (Int) -> Unit,  selectedRoute: String, modifier: Modifier = Modifier, navHostController: NavHostController) {

	
	Box(
		modifier = Modifier
			.fillMaxWidth()
			.padding(bottom = 40.dp)
			.background(
				Color.LightGray.copy(alpha = 0.2f),
				RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
			           )
	   ) {
		Row(
			modifier = Modifier.fillMaxWidth(),
			horizontalArrangement = Arrangement.SpaceBetween,
			verticalAlignment = Alignment.CenterVertically
		   ) {
			BottomNavItem(
				icon = R.drawable.home_icon, // Replace with your icons
				label = "Status",
				isSelected =  selectedIndex ==0,
				onClick = { onItemSelected(0) }
				
			
			             )
			
			BottomNavItem(
				icon = R.drawable.send_icon, // Replace with your icons
				label = "Send",
				isSelected =  selectedIndex ==1,
				onClick = { onItemSelected(1) }

			             )
			
			// Empty space for the middle button
			Spacer(modifier = Modifier.width(60.dp))
			
			BottomNavItem(
				icon = R.drawable.luggage_icon, // Replace with your icons
				label = "My Luggage",
				isSelected =  selectedIndex ==2,
				onClick = { onItemSelected(2) }
//				onClick = {
//					onItemSelected("myluggage")
////					navHostController.navigate("myluggage") {
////						popUpTo(navHostController.graph.findStartDestination().id) {
////							saveState = true
////						}
////						launchSingleTop =
////							true								// Restore state when reselecting a previously selected item
////						restoreState = true
////					}
//				}
			             )
			
			BottomNavItem(
				icon = R.drawable.trip_icon, // Replace with your icons
				label = "Trips",
				isSelected = selectedIndex ==3,
				onClick = { onItemSelected(3) }
//				onClick = {
//					//onItemSelected(3)
////					navHostController.navigate("trips") {
////						popUpTo(navHostController.graph.findStartDestination().id) {
////							saveState = true
////						}
////						launchSingleTop =
////							true								// Restore state when reselecting a previously selected item
////						restoreState = true
////					}
//				}
			             )
		}
		
		// Central Circular Button
		FloatingActionButton(
			onClick = {

			},
			shape = CircleShape,
			containerColor = colorResource(id = R.color.app_yellow),
			
			modifier = Modifier
				
				.size(60.dp)
				.align(Alignment.Center)
				.offset(y = (-15).dp, x = (-10).dp)
				
			,
			
			
					//elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation(defaultElevation = 0.dp)
		                    ) {
			Image(
				painter = painterResource(id = R.drawable.wing_icon), // Replace with your center icon
				contentDescription = "Center Icon"
			     )
		}
	}
}

@Composable
fun BottomNavItem(icon: Int, label: String, isSelected: Boolean, onClick: () -> Unit) {
	println("ZZZZZ $isSelected  for  $label "  )
	
	Box {
		Column(
			modifier = Modifier
				.padding(8.dp)
				.clickable(
					
					onClick = onClick,
						  ),
			
			horizontalAlignment = Alignment.CenterHorizontally
		      ) {
			Image(
				painter = painterResource(id = icon),
				colorFilter = ColorFilter.tint(if (isSelected) colorResource(id = R.color.app_yellow) else Color.Gray),
				contentDescription = label,
				modifier = Modifier.size(24.dp),
			     )
			Spacer(modifier = Modifier.height(4.dp))
			Text(
				text = label,
				fontSize = 12.sp,
				fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
				color = if (isSelected) colorResource(id = R.color.app_yellow) else Color.Gray
			    )
		}
	}
}


