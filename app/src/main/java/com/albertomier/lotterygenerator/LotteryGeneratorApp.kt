package com.albertomier.lotterygenerator

import android.app.Application
import com.albertomier.lotterygenerator.core.utils.SharedPreferenceUtils
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class LotteryGeneratorApp  : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this

        initComponents()
    }

    private fun initComponents() {

    }

    companion object {
        private lateinit var instance: LotteryGeneratorApp
        var sharedPreferenceUtils: SharedPreferenceUtils? = null

        fun getAppInstance(): LotteryGeneratorApp {
            return instance
        }
    }
}
