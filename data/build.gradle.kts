@file:Suppress("DEPRECATION")

plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    namespace = Config.applicationId
    compileSdk = Config.compileSdk
    defaultConfig {
        minSdk = Config.minSdk
        targetSdk = Config.targetSdk
        testInstrumentationRunner = Config.testInstrumentationRunner
        consumerProguardFiles(Config.consume)
    }
    buildTypes {
        release {
            proguardFiles(
                getDefaultProguardFile(Config.proguardFile),
                Config.proguard
            )
        }
    }
    compileOptions {
        sourceCompatibility(Config.sourceCompatibility)
        targetCompatibility(Config.sourceCompatibility)
    }
    kotlinOptions { jvmTarget = Config.jvmTarget }
}

dependencies {
    data()
    implementation(project(":shared"))
}