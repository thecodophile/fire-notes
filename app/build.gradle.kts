plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)

    // Add the Google services Gradle plugin
    alias(libs.plugins.google.services)
    // Dagger hilt
    alias(libs.plugins.hilt.android)

    alias { libs.plugins.kotlin.serialization }

    id("kotlin-kapt")
}

android {
    namespace = "com.somnathdey.firenotes"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.somnathdey.firenotes"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(project(":auth:ui"))
    implementation(project(":auth:data"))
    implementation(project(":auth:domain"))

    implementation(project(":notes:ui"))
    implementation(project(":notes:data"))
    implementation(project(":notes:domain"))

    implementation(project(":shared-notes:ui"))
    implementation(project(":shared-notes:data"))
    implementation(project(":shared-notes:domain"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    // Import the Firebase BoM
    implementation(platform(libs.firebase.bom))


    /*Add the dependencies for Firebase products you want to use
    When using the BoM, don't specify versions in Firebase dependencies*/

//    implementation(libs.firebase.analytics)


    // Coroutine
    implementation(libs.coroutine.android)

    // Dependency Injection
    implementation(libs.hilt.android)
    implementation(libs.androidx.hilt.navigation.compose)
    kapt(libs.hilt.android.compiler)
}