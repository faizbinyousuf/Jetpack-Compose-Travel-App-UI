package com.example.travelapp.features.Download

import android.app.DownloadManager
import android.content.Context
import android.net.Uri
import android.os.Environment
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.travelapp.common.components.CommonAppBar
import com.example.travelapp.common.service.DownloadService
import kotlinx.coroutines.launch
import java.net.URLDecoder
import java.nio.charset.StandardCharsets


@Composable
fun DownloadFileExample(
    navController: NavHostController
) {
    val context = LocalContext.current // Get the current context
val downloadService = DownloadService()
    var scope = rememberCoroutineScope()



    Scaffold(

        topBar = {
            CommonAppBar(navController = navController,
                title = "Download File",

                onNavigationIconClick = {

                }
            )
        }
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
                .padding(it),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = {
                    val fileUrl =
                        "https://www.demolandia.ovh/downloads/brands/uhd/lg/lg-uhd-LG-Greece-and-Norway-(www.demolandia.net).mp4" // Replace with a valid URL
                    scope.launch {
                        startDownload(context, fileUrl)
                    }
                },

                ) {
                Text("Download Sample File", style = TextStyle(
                    color = Color.White
                ))
            }
        }
    }
}


fun startDownload( context: Context, url: String) {


    // Extract the filename from the URL
    val fileName = url.substringAfterLast('/').let {
        URLDecoder.decode(it, StandardCharsets.UTF_8.toString())
    }

    val downloadManager = context.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager

    val request = DownloadManager.Request(Uri.parse(url))
        .setTitle("Downloading $fileName")
        .setMimeType("video/mp4")
        .setDescription("Downloading file from $url")
        .setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, fileName)
        .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)

    // Enqueue the download request
    downloadManager.enqueue(request)
}
