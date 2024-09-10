package com.example.travelapp.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with
val Typography = Typography(
	bodyLarge = TextStyle(
		fontFamily = FontFamily.Default,
		fontWeight = FontWeight.Normal,
		fontSize = 16.sp,
		lineHeight = 24.sp,
		letterSpacing = 0.5.sp
	                     ),
	bodyMedium = TextStyle(  // for all body normal texts
		fontFamily = FontFamily.Default,
		fontWeight = FontWeight.W400,
		fontSize = 14.sp,
		lineHeight = 16.sp,
		letterSpacing = 0.5.sp
	                      ),
	bodySmall = TextStyle(  // for all body small texts eg : document upload screen
		fontFamily = FontFamily.Default,
		fontWeight = FontWeight.W400,
		fontSize = 12.sp,
		lineHeight = 12.sp,
		letterSpacing = 0.5.sp
	                     ),
	
	titleLarge = TextStyle( // lets get started
		fontFamily = FontFamily.Default,
		fontWeight = FontWeight.W700 ,
		fontSize = 27.sp,
		lineHeight = 31.sp,
		letterSpacing = 0.sp
	                      ),
	titleMedium = TextStyle( // welcome screen for example
		fontFamily = FontFamily.Default,
		fontWeight = FontWeight.W400,
		fontSize = 18.sp,
		lineHeight = 21.sp,
		letterSpacing = 0.5.sp
	                       ),
	titleSmall = TextStyle(   // For AppBar titles
		fontFamily = FontFamily.Default,
		fontWeight = FontWeight.W500,
		fontSize = 14.sp,
		lineHeight = 16.sp,
		letterSpacing = 0.5.sp
	                      ),
	labelSmall = TextStyle(
		fontFamily = FontFamily.Default,
		fontWeight = FontWeight.Medium,
		fontSize = 11.sp,
		lineHeight = 16.sp,
		letterSpacing = 0.5.sp
	                      ),
	labelMedium = TextStyle(
		fontFamily = FontFamily.Default,
		fontWeight = FontWeight.Medium,
		fontSize = 14.sp,
		lineHeight = 20.sp,
		letterSpacing = 0.5.sp
	                       ),
	labelLarge = TextStyle(
		fontFamily = FontFamily.Default,
		fontWeight = FontWeight.Medium,
		fontSize = 16.sp,
		lineHeight = 24.sp,
		letterSpacing = 0.5.sp
	                      ),
	
	headlineMedium = TextStyle( // for sign in , sign up etc headings
		fontFamily = FontFamily.Default,
		fontWeight = FontWeight.W200,
		fontSize = 36.sp,
		lineHeight = 42.sp,
//		letterSpacing = 0.5.sp
	                          ),
	
	
	)

val buttonLabelStyle = TextStyle(
	fontFamily = FontFamily.Default,
	fontWeight = FontWeight.W700,
	fontSize = 18.sp,
	lineHeight = 20.sp,
	letterSpacing = 0.5.sp
                           )
	