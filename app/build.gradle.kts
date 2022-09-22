plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
}

android {
    namespace = "com.example.shopmiumbindings"
    compileSdk = 32

    defaultConfig {
        applicationId = "com.example.shopmiumbindings"
        minSdk = 26
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
        managedDevices {
            devices {
                maybeCreate<com.android.build.api.dsl.ManagedVirtualDevice>("pixel2api30").apply {
                    // Use device profiles you typically see in Android Studio.
                    device = "Pixel 2"
                    // Use only API levels 27 and higher.
                    apiLevel = 30
                    // To include Google services, use "google".
                    systemImageSource = "aosp-atd"
                }
            }
        }
    }

    buildFeatures {
        viewBinding = true
        dataBinding = true
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.8.0")
    implementation("androidx.appcompat:appcompat:1.5.1")
    implementation("com.google.android.material:material:1.6.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.5.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.1")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
    androidTestImplementation("androidx.test:core:1.5.0-alpha02")
    androidTestImplementation("androidx.test:runner:1.5.0-alpha04")
    androidTestImplementation("androidx.test:rules:1.4.1-alpha07")
    androidTestImplementation("androidx.test.ext:junit-ktx:1.1.4-alpha07")
    androidTestImplementation("androidx.test.espresso:espresso-contrib:3.5.0-alpha07")
    androidTestImplementation("androidx.test.espresso:espresso-intents:3.5.0-alpha07")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.0-alpha07")
    androidTestImplementation("androidx.test.espresso:espresso-idling-resource:3.5.0-alpha07")
    androidTestImplementation("androidx.test.espresso.idling:idling-concurrent:3.5.0-alpha07")
    androidTestImplementation("androidx.test.uiautomator:uiautomator:2.2.0")
}
