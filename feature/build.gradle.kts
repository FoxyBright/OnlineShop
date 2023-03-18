@file:Suppress("DEPRECATION", "UnstableApiUsage")

plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    namespace = "${Config.applicationPrefix}.feature"
    compileSdk = Config.compileSdk
    defaultConfig {
        minSdk = Config.minSdk
        targetSdk = Config.targetSdk
        testInstrumentationRunner = Config.testInstrumentationRunner
        consumerProguardFiles(Config.consume)
    }
    buildFeatures { compose = true }
    composeOptions {
        kotlinCompilerExtensionVersion = Config.kotlinCompilerExVer
        kotlinCompilerVersion = Config.kotlinCompilerVer
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
    feature()
    implementation(project(":domain"))
    implementation(project(":shared"))
}