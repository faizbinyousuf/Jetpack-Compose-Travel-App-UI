package com.example.travelapp.ui.theme


import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.unit.sp
import com.example.travelapp.R


//val RalewayFontFamily = FontFamily(
//	Font(R. ., FontWeight.Normal),
//	Font(R.font.custom_font_bold, FontWeight.Bold)
//                                 )


val provider = GoogleFont.Provider(
	providerAuthority = "com.google.android.gms.fonts",
	providerPackage = "com.google.android.gms",
	certificates = R.array.com_google_android_gms_fonts_certs
                                  )

val fontName = GoogleFont("Raleway")
val font = GoogleFont("Roboto")
val ubuntuFont = GoogleFont("Ubuntu")


val raleWay = FontFamily(
	Font(
		googleFont = fontName,
		fontProvider = provider,
		
		
		),
                        )

val roboto = FontFamily(
	Font(
		googleFont = font,
		fontProvider = provider,
	    )
                       )
val ubuntu = FontFamily(
	Font(
		googleFont = ubuntuFont,
		fontProvider = provider,
	    )
					   )

// Set of Material typography styles to start with
val Typography = Typography(
	bodyLarge = TextStyle(
		fontFamily = ubuntu,
		fontWeight = FontWeight.Normal,
		fontSize = 16.sp,
		lineHeight = 24.sp,
		letterSpacing = 0.5.sp
	                     ),
	bodyMedium = TextStyle(  // for all body normal texts
		fontFamily = ubuntu,
		fontWeight = FontWeight.W400,
		fontSize = 14.sp,
		lineHeight = 16.sp,
		letterSpacing = 0.5.sp
	                      ),
	bodySmall = TextStyle(  // for all body small texts eg : document upload screen
		fontFamily = ubuntu,
		fontWeight = FontWeight.W400,
		fontSize = 12.sp,
		lineHeight = 12.sp,
		letterSpacing = 0.5.sp
	                     ),
	
	titleLarge = TextStyle( // lets get started
		fontFamily = ubuntu,
		fontWeight = FontWeight.W700,
		fontSize = 27.sp,
		lineHeight = 31.sp,
		letterSpacing = 0.sp
	                      ),
	titleMedium = TextStyle( // welcome screen for example
		fontFamily = ubuntu,
		fontWeight = FontWeight.W400,
		fontSize = 18.sp,
		lineHeight = 21.sp,
		letterSpacing = 0.5.sp
	                       ),
	titleSmall = TextStyle(   // For AppBar titles
		fontFamily = ubuntu,
		fontWeight = FontWeight.W500,
		fontSize = 14.sp,
		lineHeight = 16.sp,
		letterSpacing = 0.5.sp
	                      ),
	labelSmall = TextStyle(
		fontFamily = ubuntu,
		fontWeight = FontWeight.Medium,
		fontSize = 11.sp,
		lineHeight = 16.sp,
		letterSpacing = 0.5.sp
	                      ),
	labelMedium = TextStyle(
		fontFamily = ubuntu,
		fontWeight = FontWeight.Medium,
		fontSize = 14.sp,
		lineHeight = 20.sp,
		letterSpacing = 0.5.sp
	                       ),
	labelLarge = TextStyle(
		fontFamily = ubuntu,
		fontWeight = FontWeight.Medium,
		fontSize = 16.sp,
		lineHeight = 24.sp,
		letterSpacing = 0.5.sp
	                      ),
	
	headlineMedium = TextStyle(
		// for sign in , sign up etc headings
		fontFamily = ubuntu,
		fontWeight = FontWeight.W200,
		fontSize = 36.sp,
		lineHeight = 42.sp, //		letterSpacing = 0.5.sp
	                          ),
	
	
	)

val buttonLabelStyle = TextStyle(
	fontFamily = raleWay,
	fontWeight = FontWeight.W700,
	fontSize = 18.sp,
	lineHeight = 20.sp,
	letterSpacing = 0.5.sp
                                )
	