import com.example.buildsrc.Dep

plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
    kotlin("plugin.serialization")
}

android {
    namespace = "com.example.domain"
    compileSdk = com.example.buildsrc.Versions.compileSdk
}
kotlin {
    jvmToolchain(17)
}

dependencies {
    implementation(project(com.example.buildsrc.Project.data))
    implementation(Dep.Hilt.hilt)
    kapt(Dep.Hilt.compiler)
    implementation(Dep.Kotlin.serializationJson)
    Dep.Kotlin.CoroutineList.forEach(::implementation)
    Dep.Retrofit.RetrofitList.forEach(::implementation)
}