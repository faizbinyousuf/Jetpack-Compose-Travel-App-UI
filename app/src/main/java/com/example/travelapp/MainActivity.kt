package com.example.travelapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.core.view.WindowCompat
import androidx.navigation.compose.rememberNavController
import com.example.travelapp.common.route.TravelAppNavHost
import com.example.travelapp.ui.theme.TravelAppTheme

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		enableEdgeToEdge()
		WindowCompat.setDecorFitsSystemWindows(window, false)
		
		setContent {
			
			TravelAppTheme {
				val navController = rememberNavController()
				Surface {
					TravelAppNavHost(navController = navController)
				//					AuthWrapper(navHostController = navController)
				}
				
				
			}
		}
	}
}



@Composable
fun OrdersScreen() {
	Text(text = "Orders Screen")
}

@Composable
fun ProfileScreen() {
	Text(text = "Profile Screen")
}

