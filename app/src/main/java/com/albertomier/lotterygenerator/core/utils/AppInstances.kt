package com.albertomier.lotterygenerator.core.utils

import com.albertomier.lotterygenerator.LotteryGeneratorApp

object AppInstances {
    fun getSharedPreferencesInstance(): SharedPreferenceUtils {
        return if (LotteryGeneratorApp.sharedPreferenceUtils == null) {
            LotteryGeneratorApp.sharedPreferenceUtils = SharedPreferenceUtils()
            LotteryGeneratorApp.sharedPreferenceUtils!!
        } else {
            LotteryGeneratorApp.sharedPreferenceUtils!!
        }
    }
}