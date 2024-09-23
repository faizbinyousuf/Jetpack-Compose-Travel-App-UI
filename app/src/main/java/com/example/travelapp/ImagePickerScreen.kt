package com.example.travelapp

import android.Manifest
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionStatus
import com.google.accompanist.permissions.rememberPermissionState
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import com.google.accompanist.permissions.*

import com.google.accompanist.permissions.rememberPermissionState
import kotlinx.coroutines.launch
import  androidx.compose.foundation.Image
import androidx.compose.material3.ModalBottomSheet

//
//class CameraActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            // Your existing UI components can go here
//
//
//            // Add ImagePickerScreen wherever appropriate
//            ImagePickerScreen()
//        }
//    }
//}


@OptIn(ExperimentalPermissionsApi::class, ExperimentalMaterial3Api::class)
@Composable
fun ImagePickerScreen() {

    var showBottomSheet by remember { mutableStateOf(false) }
    var selectedImageUri by remember { mutableStateOf <ImageBitmap?> (null) }

    var imageFromGallery by remember {
        mutableStateOf<Uri?>(null)
    }

    //BottomSheetScaffoldState
    val bottomSheetState = rememberModalBottomSheetState()

        //rememberModalBottomSheetState()
    val coroutineScope = rememberCoroutineScope()

    // Permission states for camera and storage
    val cameraPermissionState = rememberPermissionState(permission = Manifest.permission.CAMERA)
    val storagePermissionState = rememberMultiplePermissionsState(
        permissions = listOf(
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
        )
    )

    // Gallery launcher
    val galleryLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        onResult = { uri ->

            showBottomSheet = false
            uri?.let {
                imageFromGallery = it
            }
        }
    )
    // Camera launcher (here it’s simplified, in real apps, you'd need to handle file creation)
    val cameraLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.TakePicturePreview(),

        onResult = {isSuccess: Bitmap? ->
            selectedImageUri = isSuccess?.asImageBitmap()
            showBottomSheet = false
            coroutineScope.launch {
//                bottomSheetState.bottomSheetState.hide()
            }
        },
    )


    LaunchedEffect(
        cameraPermissionState.status,
        storagePermissionState.allPermissionsGranted
    ) {


        if (!(cameraPermissionState.status== PermissionStatus.Granted)) {
          // show snackbar
            cameraPermissionState.launchPermissionRequest()
        }
        if (!storagePermissionState.allPermissionsGranted) {
            storagePermissionState.launchMultiplePermissionRequest()
        }
    }

    if(showBottomSheet){

        ModalBottomSheet(
            onDismissRequest = { showBottomSheet = false },
            sheetState = bottomSheetState,
            containerColor = Color.White,

        ) {
            Column(
                Modifier.padding(16.dp)
            ) {
                TextButton(
                    onClick = {
                        // cameraLauncher.launch(null)
                        cameraPermissionState.launchPermissionRequest()
                        if (cameraPermissionState.status== PermissionStatus.Granted) {
                            cameraLauncher.launch(null)
                        } else {
                            cameraPermissionState.launchPermissionRequest()
                        }
                    }

                ) {
                    Text("Take Photo")
                }
                TextButton(onClick = {

                    galleryLauncher.launch("image/*")

//                    if (storagePermissionState.permissions.all { it.status == PermissionStatus.Granted }) {
//                        galleryLauncher.launch("image/*")
//                    } else {
//                        storagePermissionState.launchMultiplePermissionRequest()
//                    }
                }) {
                    Text("Choose from Gallery")
                }
            }
        }

    }


        Scaffold(

            topBar = {
                TopAppBar(title = { Text("Image Picker") })
            },
            content = {
                pad ->
                Column(
                    modifier = Modifier.fillMaxSize()
                        .padding(pad),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Button(
//                        onClick = { showBottomSheet = true }
                        onClick = {
                            showBottomSheet = true

                        }



                    ) {

                        Text("Pick Image")
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    selectedImageUri?.let {

                        //
                       Image(
                            bitmap = it,
                            contentDescription = null,
                            modifier = Modifier.size(200.dp),
                            contentScale = ContentScale.Crop
                       )
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    imageFromGallery?.let {

                        //
                        Image(
                          painter =  rememberAsyncImagePainter(
                              model = it
                          ),
                            contentDescription = null,
                            modifier = Modifier.size(200.dp),
                            contentScale = ContentScale.Crop
                        )
                    }
                }
            }
        )
}
