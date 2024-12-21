plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "kr.ac.kumoh.s20191091.s24w1403retrofit"
    compileSdk = 35

    defaultConfig {
        applicationId = "kr.ac.kumoh.s20191091.s24w1403retrofit"
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
    // Note: Navigation 사용하기 위해 추가
    //implementation("androidx.navigation:navigation-compose:2.8.5")
    implementation(libs.androidx.navigation.compose)

    // NOTE: AsyncImage 사용하기 위해 추가
    implementation(libs.coil.compose)
    implementation(libs.coil.network.okhttp)

    // NOTE: Retrofit 사용하기 위해 추가
    implementation(libs.retrofit)
    implementation(libs.converter.gson)

    // NOTE: viewModel() 사용하기 위해 추가
    implementation(libs.androidx.lifecycle.viewmodel.compose)

    // NOTE: observeAsState 사용하기 위해 추가
    implementation(libs.androidx.runtime.livedata)

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
}