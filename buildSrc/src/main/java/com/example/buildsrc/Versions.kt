package com.example.buildsrc

import org.gradle.api.JavaVersion

object Versions {
    const val projectName = "com.example.multimodulebaseproject"
    const val minSdk = 26
    const val targetSdk = 33
    const val compileSdk = 33
    const val jvmTarget = "11"

    val javaVersion = JavaVersion.VERSION_11
}