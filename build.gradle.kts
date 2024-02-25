// Top-level build file where you can add configuration options common to all sub-projects/modules.
//plugins {
//    id("com.android.application") version "8.1.0" apply false
//    id("org.jetbrains.kotlin.android") version "1.8.10" apply false
//    id("com.android.library") version "8.1.0" apply false
//}
plugins {
    kotlin("jvm") version "1.9.0"
    kotlin("plugin.serialization") version "1.9.0" apply false
//    id("com.google.dagger.hilt.android") version "2.28-alpha" apply false
}

buildscript {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        maven(url = "https/jitpack.io")
    }

    dependencies {
        classpath(com.example.buildsrc.Dep.androidGradlePlugin)
        classpath(com.example.buildsrc.Dep.androidGradleApiPlugin)
        classpath(com.example.buildsrc.Dep.Kotlin.gradlePlugin)
        classpath(com.example.buildsrc.Dep.Hilt.plugin)
    }
}
