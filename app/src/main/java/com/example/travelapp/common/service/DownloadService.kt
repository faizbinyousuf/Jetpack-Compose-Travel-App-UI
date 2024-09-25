package com.example.travelapp.common.service

import android.app.DownloadManager
import android.content.Context
import android.net.Uri
import android.os.Environment
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat.getSystemService
import java.net.URLDecoder
import java.nio.charset.StandardCharsets


class DownloadService {

//    private fun enqueueDownloadRequest(
//        url: String
//    ) {
//
//        if (url.isEmpty()) {
//
//
//            return
//        }
//        val request: DownloadManager.Request = DownloadManager.Request(Uri.parse(url))
//        with(request) {
//            setTitle("Test pdf")
//            setMimeType("pdf")
//            setDescription("Downloading pdf...")
//            setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
//            setDestinationInExternalPublicDir(
//                Environment.DIRECTORY_DOWNLOADS,
//                "test.pdf"
//            )
//        }
////        val manager: DownloadManager =
////            requireContext().getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
//
//        val manager: DownloadManager =
//            getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
//        manager.enqueue(request)
//    }
//






}

@Composable
fun showToast(message: String) {
    val context = LocalContext.current

    Toast.makeText(context, message, Toast.LENGTH_SHORT).show() // Show the toast
}