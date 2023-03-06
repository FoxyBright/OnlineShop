@Suppress("GradleDependency", "AndroidGradlePluginVersion") buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:8.0.0-beta02")
        classpath("com.android.tools.build:gradle-api:8.0.0-beta02")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

plugins {
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}