plugins {
	alias(libs.plugins.android.application)
	alias(libs.plugins.jetbrains.kotlin.android)
	id("com.google.gms.google-services")
}



android {
	namespace = "com.example.travelapp"
	compileSdk = 34
	
	defaultConfig {
		applicationId = "com.example.travelapp"
		minSdk = 30
		targetSdk = 34
		versionCode = 1
		versionName = "1.0"
		
		testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
		vectorDrawables {
			useSupportLibrary = true
		}
	}
	
	buildTypes {
		release {
			isMinifyEnabled = false
			proguardFiles(
				getDefaultProguardFile("proguard-android-optimize.txt"),
				"proguard-rules.pro"
			             )
		}
	}
	compileOptions {
		sourceCompatibility = JavaVersion.VERSION_1_8
		targetCompatibility = JavaVersion.VERSION_1_8
	}
	kotlinOptions {
		jvmTarget = "1.8"
	}
	buildFeatures {
		compose = true
	}
	composeOptions {
		kotlinCompilerExtensionVersion = "1.5.1"
	}
	packaging {
		resources {
			excludes += "/META-INF/{AL2.0,LGPL2.1}"
		}
	}
}

dependencies {


	// firebase sdk
	implementation(platform("com.google.firebase:firebase-bom:33.3.0"))

	// firebase analytics

	implementation("com.google.firebase:firebase-analytics")

	//firebase messaging dependcency
	implementation("com.google.firebase:firebase-messaging")

	// Data store dependency (|advcanced version of SharedPreferences)
	implementation("androidx.datastore:datastore-preferences:1.0.0")
	

	
	implementation ("androidx.constraintlayout:constraintlayout-compose:1.0.0")
	implementation("androidx.compose.ui:ui-text-google-fonts:1.7.0")
	implementation ("androidx.activity:activity-compose:1.7.2")
	implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
	implementation ("com.google.accompanist:accompanist-permissions:0.33.0-alpha")


// import coil library

	implementation("io.coil-kt:coil-compose:2.7.0")





	implementation(libs.androidx.core.ktx)
	implementation(libs.androidx.lifecycle.runtime.ktx)
	implementation(libs.androidx.activity.compose)
	implementation(platform(libs.androidx.compose.bom))
	implementation(libs.androidx.ui)
	implementation(libs.androidx.ui.graphics)
	implementation(libs.androidx.ui.tooling.preview)
	implementation(libs.androidx.material3)
	implementation(libs.androidx.navigation.compose)
	implementation(libs.androidx.material3)
	implementation(libs.androidx.constraintlayout)
	implementation(libs.androidx.media3.exoplayer)
	implementation("androidx.media3:media3-ui:1.2.0")
	//implementation(libs.androidx.media3.ui)
	testImplementation(libs.junit)
	androidTestImplementation(libs.androidx.junit)
	androidTestImplementation(libs.androidx.espresso.core)
	androidTestImplementation(platform(libs.androidx.compose.bom))
	androidTestImplementation(libs.androidx.ui.test.junit4)
	debugImplementation(libs.androidx.ui.tooling)
	debugImplementation(libs.androidx.ui.test.manifest)



}