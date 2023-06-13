package com.albertomier.lotterygenerator.core.data.numbers

import android.util.Log

class Euromillones : Numbers() {
    private val numbersFileName = "euromillones_numbers.txt"
    private val starsFileName = "euromillones_stars.txt"

    fun main(): HashMap<String, List<Int>> {
        Log.e("AMIER", "generando numeros")
        val numbers = readFile(numbersFileName)
        val stars = readFile(starsFileName)

        val numbersMap = numbers.groupingBy { it }.eachCount()
        val starsMap = stars.groupingBy { it }.eachCount()

        val sortedNumbersByKey = numbersMap.toSortedMap(compareByDescending { it })
        val sortedNumbersByValueAscending = numbersMap.entries.sortedBy { it.value }.associate { it.toPair() }
        val sortedNumbersByValueDescending = numbersMap.entries.sortedByDescending { it.value }.associate { it.toPair() }

        val sortedStarsByKey = starsMap.toSortedMap(compareByDescending { it })
        val sortedStarsByValueAscending = starsMap.entries.sortedBy { it.value }.associate { it.toPair() }
        val sortedStarsByValueDescending = starsMap.entries.sortedByDescending { it.value }.associate { it.toPair() }

        val numbersMost = ArrayList<Int>()
        val starsMost = ArrayList<Int>()

        sortedNumbersByValueDescending.map {
            if (numbersMost.size < 15) {
                numbersMost.add(it.key)
            }
        }

        sortedStarsByValueDescending.map {
            if (starsMost.size < 5) {
                starsMost.add(it.key)
            }
        }

        val value = HashMap<String, List<Int>>()
        value["numbers"] = numbersMost
        value["stars"] = starsMost

        Log.e("AMIER", "numeros generados")

        return value
    }
}