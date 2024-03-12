import com.example.buildsrc.Dep
import com.example.buildsrc.Project

plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
    kotlin("plugin.serialization")
}

android {
    namespace = "com.example.data"
    compileSdk = com.example.buildsrc.Versions.compileSdk
}
kotlin {
    jvmToolchain(17)
}
dependencies {

    implementation(Dep.Kotlin.serializationJson)

    implementation(Dep.Hilt.hilt)
    kapt(Dep.Hilt.compiler)
    debugImplementation(Dep.Flipper.core)
    debugImplementation(Dep.Flipper.soloader)
    debugImplementation(Dep.Flipper.networkplugin)
    releaseImplementation(Dep.Flipper.noop)

    Dep.Retrofit.RetrofitList.forEach(::implementation)
    implementation(Dep.Google.gson)
}