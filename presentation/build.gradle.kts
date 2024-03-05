import com.example.buildsrc.*
plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.example.presentation"
    compileSdk = Versions.compileSdk

    buildFeatures {
        compose = true

    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.0"
    }
}


kotlin {
    jvmToolchain(17)
}

dependencies {

    implementation(project(com.example.buildsrc.Project.domain))

    Dep.androidList.forEach(::implementation)
    Dep.LifeCycle.LifeCycleList.forEach(::implementation)
    Dep.Compose.ComposeList.forEach(::implementation)

    implementation(Dep.Kotlin.stdlib)

    Dep.Kotlin.CoroutineList.forEach(::implementation)
    implementation(Dep.Hilt.hilt)
    kapt(Dep.Hilt.compiler)

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}