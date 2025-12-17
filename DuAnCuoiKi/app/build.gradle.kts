plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "ntu.tienthinh.duancuoiki"
    compileSdk = 36

    defaultConfig {
        applicationId = "ntu.tienthinh.duancuoiki"
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
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    // Thư viện Retrofit để xử lý HTTP/API calls
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
// Thư viện chuyển đổi JSON sang Java Object (Gson)
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("androidx.cardview:cardview:1.0.0")
}