import com.example.buildsrc.Dep
plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.example.domain"
}

dependencies {
    implementation(Dep.Hilt.hilt)
    kapt(Dep.Hilt.compiler)

    Dep.Kotlin.CoroutineList.forEach(::implementation)
    Dep.Retrofit.RetrofitList.forEach(::implementation)
}