package com.albertomier.lotterygenerator.core.data.numbers

import android.util.Log

class Bonoloto  : Numbers() {
    private val numbersFileName = "bonoloto_numbers.txt"
    private val reintegroFileName = "bonoloto_reintegro.txt"
    private val complementarioFileName = "bonoloto_complementario.txt"

    fun main(): HashMap<String, List<Int>> {
        Log.e("AMIER", "generando numeros")
        val numbers = readFile(numbersFileName)
        val reintegro = readFile(reintegroFileName)
        val complementario = readFile(complementarioFileName)

        val numbersMap = numbers.groupingBy { it }.eachCount()
        val reintegroMap = reintegro.groupingBy { it }.eachCount()
        val complementarioMap = complementario.groupingBy { it }.eachCount()

        val sortedNumbersByValueDescending = numbersMap.entries.sortedByDescending { it.value }.associate { it.toPair() }
        val sortedReintegroByValueDescending = reintegroMap.entries.sortedByDescending { it.value }.associate { it.toPair() }
        val sortedComplementarioByValueDescending = complementarioMap.entries.sortedByDescending { it.value }.associate { it.toPair() }

        val numbersMost = ArrayList<Int>()
        val reintegroMost = ArrayList<Int>()
        val complementarioMost = ArrayList<Int>()

        sortedNumbersByValueDescending.map {
            if (numbersMost.size < 15) {
                numbersMost.add(it.key)
            }
        }

        sortedReintegroByValueDescending.map {
            if (reintegroMost.size < 5) {
                reintegroMost.add(it.key)
            }
        }

        sortedComplementarioByValueDescending.map {
            if (complementarioMost.size < 5) {
                complementarioMost.add(it.key)
            }
        }

        val value = HashMap<String, List<Int>>()
        value["numbers"] = numbersMost
        value["reintegro"] = reintegroMost
        value["complementario"] = complementarioMost

        Log.e("AMIER", "numeros generados")

        return value
    }
}