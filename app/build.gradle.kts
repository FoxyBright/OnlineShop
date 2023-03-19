@file:Suppress("DEPRECATION", "UnstableApiUsage")

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("realm-android")
}

android {
    namespace = Config.applicationId
    compileSdk = Config.compileSdk
    defaultConfig {
        applicationId = Config.applicationId
        minSdk = Config.minSdk
        targetSdk = Config.targetSdk
        versionCode = Config.versionCode
        versionName = Config.versionName
        testInstrumentationRunner = Config.testInstrumentationRunner
        vectorDrawables { useSupportLibrary = true }
    }
    buildFeatures { compose = true }
    
    composeOptions {
        kotlinCompilerExtensionVersion = Config.kotlinCompilerExVer
        kotlinCompilerVersion = Config.kotlinCompilerVer
    }
    kotlinOptions { jvmTarget = Config.jvmTarget }
    buildFeatures { compose = true }
    compileOptions {
        sourceCompatibility(Config.sourceCompatibility)
        targetCompatibility(Config.sourceCompatibility)
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    app()
    implementation(project(":feature"))
    implementation(project(":domain"))
    implementation(project(":shared"))
    implementation(project(":data"))
}