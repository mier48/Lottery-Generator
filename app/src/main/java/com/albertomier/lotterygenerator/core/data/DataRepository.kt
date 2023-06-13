package com.albertomier.lotterygenerator.core.data

import com.albertomier.lotterygenerator.core.data.numbers.Bonoloto
import com.albertomier.lotterygenerator.core.data.numbers.Euromillones
import com.albertomier.lotterygenerator.core.data.numbers.Primitiva
import javax.inject.Inject

class DataRepository @Inject constructor() {

    fun generateEuromillonesData(): HashMap<String, List<Int>> = Euromillones().main()

    fun generatePrimitivaData(): HashMap<String, List<Int>> = Primitiva().main()

    fun generateBonolotoData(): HashMap<String, List<Int>> = Bonoloto().main()
}