package com.albertomier.lotterygenerator.home.domain

import com.albertomier.lotterygenerator.core.data.DataRepository
import javax.inject.Inject

class GenerateEuromillonesNumbersUseCase @Inject constructor(private val repository: DataRepository) {

    operator fun invoke(): HashMap<String, List<Int>> = repository.generateEuromillonesData()

}