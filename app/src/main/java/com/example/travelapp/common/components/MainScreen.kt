package com.example.travelapp.common.components

import android.annotation.SuppressLint
import android.app.Activity
import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.travelapp.features.find.FindAngels
import com.example.travelapp.features.myluggage.screens.LuggageScreen
import com.example.travelapp.features.send.components.SendScreen
import com.example.travelapp.features.status.presentation.HomeScreen
import com.example.travelapp.features.trip.presentation.TripScreen


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(navController: NavHostController, index: Int? = 0) {
    var selectedIndex by rememberSaveable { mutableStateOf(0) }
    var showExitDialog by remember { mutableStateOf(false) }

    // Array of routes for bottom navigation
    val screenArray = arrayOf("status", "send", "luggage", "trips")


    // Dynamically navigate to the passed startDestination
    LaunchedEffect(Unit) {
        index?.let {
            if (index != null) {
                selectedIndex = index
            }
        }
    }


    BackHandler {
        showExitDialog = true // Show the confirmation dialog on back press
    }

    Scaffold(
        contentWindowInsets = WindowInsets(0.dp),

        bottomBar = {

            CustomBottomNavigation(selectedIndex = selectedIndex, onItemSelected = { newIndex ->
                selectedIndex = newIndex
            }, selectedRoute = screenArray[selectedIndex], navHostController = navController)


        },


        ) { it ->

        Box(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
//			.consumeWindowInsets(it)
//			.systemBarsPadding()
            ,
            contentAlignment = Alignment.BottomCenter

        ) {

            when (selectedIndex) {
                0 -> {

                    HomeScreen(navController = navController)
                }

                1 -> {
                    SendScreen(navController = navController)
                }

                2 -> {
                    LuggageScreen(navController = navController)
                }

                3 -> {

                    TripScreen(navController = navController)
                }
            }


        }


    }

    if (showExitDialog) {
        val activity = (LocalContext.current as? Activity)
        ExitConfirmationDialog(onConfirm = {


            activity?.finish()
        }, onDismiss = { showExitDialog = false })
    }
}

//var screenArray = arrayOf("status", "send", "findAngels", "profile")