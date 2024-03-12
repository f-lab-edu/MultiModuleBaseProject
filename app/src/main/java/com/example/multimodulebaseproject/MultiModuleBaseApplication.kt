package com.example.multimodulebaseproject

import android.app.Application
import androidx.compose.ui.graphics.SolidColor
import com.example.data.datasource.remote.DataModuleWithoutHilt
import com.facebook.flipper.BuildConfig
import com.facebook.flipper.android.AndroidFlipperClient
import com.facebook.flipper.android.utils.FlipperUtils
import com.facebook.flipper.plugins.inspector.DescriptorMapping
import com.facebook.flipper.plugins.inspector.InspectorFlipperPlugin
import com.facebook.flipper.plugins.network.NetworkFlipperPlugin
import com.facebook.soloader.SoLoader
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MultiModuleBaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        SoLoader.init(this,false)

        if (BuildConfig.DEBUG && FlipperUtils.shouldEnableFlipper(this)){
            val client = AndroidFlipperClient.getInstance(this)
            val networkFlipperPlugin = NetworkFlipperPlugin()
            DataModuleWithoutHilt.initializeNetworkFlipperPlugin(networkFlipperPlugin)
            client.addPlugin(InspectorFlipperPlugin(this, DescriptorMapping.withDefaults()))
            client.addPlugin(networkFlipperPlugin)
            client.start()
        }
    }
}