package com.albertomier.lotterygenerator.home.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.albertomier.lotterygenerator.home.domain.GenerateBonolotoNumbersUseCase
import com.albertomier.lotterygenerator.home.domain.GenerateEuromillonesNumbersUseCase
import com.albertomier.lotterygenerator.home.domain.GeneratePrimitivaNumbersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getEuromillonesNumbersUseCase: GenerateEuromillonesNumbersUseCase,
    private val generatePrimitivaNumbersUseCase: GeneratePrimitivaNumbersUseCase,
    private val generateBonolotoNumbersUseCase: GenerateBonolotoNumbersUseCase
) : ViewModel() {

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> get() = _loading

    /**
     * Euromillones
     */
    private val _numbersList = MutableLiveData<List<Int>>()
    val numbersList: LiveData<List<Int>> get() = _numbersList

    private val _starsList = MutableLiveData<List<Int>>()
    val starsList: LiveData<List<Int>> get() = _starsList

    /**
     * La Primitiva
     */
    private val _primitivaNumbersList = MutableLiveData<List<Int>>()
    val primitivaNumbersList: LiveData<List<Int>> get() = _primitivaNumbersList

    private val _primitivaReintegroList = MutableLiveData<List<Int>>()
    val primitivaReintegroList: LiveData<List<Int>> get() = _primitivaReintegroList

    private val _primitivaComplementarioList = MutableLiveData<List<Int>>()
    val primitivaComplementarioList: LiveData<List<Int>> get() = _primitivaComplementarioList

    /**
     * Bonoloto
     */
    private val _bonolotoNumbersList = MutableLiveData<List<Int>>()
    val bonolotoNumbersList: LiveData<List<Int>> get() = _bonolotoNumbersList

    private val _bonolotoReintegroList = MutableLiveData<List<Int>>()
    val bonolotoReintegroList: LiveData<List<Int>> get() = _bonolotoReintegroList

    private val _bonolotoComplementarioList = MutableLiveData<List<Int>>()
    val bonolotoComplementarioList: LiveData<List<Int>> get() = _bonolotoComplementarioList

    fun generateEuromillonesNumbers() {
        viewModelScope.launch {
            _loading.value = true
            val data: HashMap<String, List<Int>> = getEuromillonesNumbersUseCase()

            val numbers = data["numbers"]
            val stars = data["stars"]

            val nList = ArrayList<Int>()
            val sList = ArrayList<Int>()

            while (nList.size < 5) {
                val random = (numbers?.indices)?.random()!!
                val n = numbers[random]
                if (!nList.contains(n)) {
                    nList.add(n)
                }
            }

            while (sList.size < 2) {
                val random = (stars?.indices)?.random()!!
                val n = stars[random]
                if (!sList.contains(n)) {
                    sList.add(n)
                }
            }

            delay(1000)

            _numbersList.value = nList.sorted()
            _starsList.value = sList.sorted()
            _loading.value = false
        }
    }

    fun generatePrimitivaNumbers() {
        viewModelScope.launch {
            _loading.value = true
            val data: HashMap<String, List<Int>> = generatePrimitivaNumbersUseCase()

            val numbers = data["numbers"]
            val reintegro = data["reintegro"]
            val complementario = data["complementario"]

            val nList = ArrayList<Int>()
            val rList = ArrayList<Int>()
            val cList = ArrayList<Int>()

            while (nList.size < 6) {
                val random = (numbers?.indices)?.random()!!
                val n = numbers[random]
                if (!nList.contains(n)) {
                    nList.add(n)
                }
            }

            while (rList.size < 1) {
                val random = (reintegro?.indices)?.random()!!
                val n = reintegro[random]
                if (!rList.contains(n)) {
                    rList.add(n)
                }
            }

            while (cList.size < 1) {
                val random = (complementario?.indices)?.random()!!
                val n = complementario[random]
                if (!cList.contains(n)) {
                    cList.add(n)
                }
            }

            delay(1000)

            _primitivaNumbersList.value = nList.sorted()
            _primitivaReintegroList.value = rList
            _primitivaComplementarioList.value = cList

            _loading.value = false
        }
    }

    fun generateBonolotoNumbers() {
        viewModelScope.launch {
            _loading.value = true
            val data: HashMap<String, List<Int>> = generateBonolotoNumbersUseCase()

            val numbers = data["numbers"]
            val reintegro = data["reintegro"]
            val complementario = data["complementario"]

            val nList = ArrayList<Int>()
            val rList = ArrayList<Int>()
            val cList = ArrayList<Int>()

            while (nList.size < 6) {
                val random = (numbers?.indices)?.random()!!
                val n = numbers[random]
                if (!nList.contains(n)) {
                    nList.add(n)
                }
            }

            while (rList.size < 1) {
                val random = (reintegro?.indices)?.random()!!
                val n = reintegro[random]
                if (!rList.contains(n)) {
                    rList.add(n)
                }
            }

            while (cList.size < 1) {
                val random = (complementario?.indices)?.random()!!
                val n = complementario[random]
                if (!cList.contains(n)) {
                    cList.add(n)
                }
            }

            delay(1000)

            _bonolotoNumbersList.value = nList.sorted()
            _bonolotoReintegroList.value = rList
            _bonolotoComplementarioList.value = cList

            _loading.value = false
        }
    }
}