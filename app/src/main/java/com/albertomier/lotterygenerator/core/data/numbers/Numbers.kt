package com.albertomier.lotterygenerator.core.data.numbers

import com.albertomier.lotterygenerator.LotteryGeneratorApp
import java.io.InputStream

open class Numbers {

    fun readFile(fileName: String): List<Int> {
        val inputStream: InputStream = LotteryGeneratorApp.getAppInstance().assets.open(fileName)
        val lineList = ArrayList<Int>()

        val data: String = inputStream.bufferedReader().readLine()
        val list = data.split(",")

        list.map {
            if (it.isNotBlank()) {
                lineList.add(it.toInt())
            }
        }

        return lineList
    }
}