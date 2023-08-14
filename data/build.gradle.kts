import com.example.buildsrc.Dep

plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.example.data"
}

dependencies {

    implementation(Dep.Hilt.hilt)
    kapt(Dep.Hilt.compiler)

    Dep.Retrofit.RetrofitList.forEach(::implementation)
}