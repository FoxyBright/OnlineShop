buildscript {
    repositories {
        mavenCentral()
        google()
    }
}

allprojects {
    repositories {
        mavenCentral()
        google()
    }
}

plugins {
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}