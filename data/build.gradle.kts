import com.example.buildsrc.Dep

plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
    kotlin("plugin.serialization")
}

android {
    namespace = "com.example.data"
}

dependencies {
    implementation(project(com.example.buildsrc.Project.domain))

    implementation(Dep.Kotlin.serializationJson)

    implementation(Dep.Hilt.hilt)
    kapt(Dep.Hilt.compiler)

    Dep.Retrofit.RetrofitList.forEach(::implementation)
    implementation(Dep.Google.gson)
}