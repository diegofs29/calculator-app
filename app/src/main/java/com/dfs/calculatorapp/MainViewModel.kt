package com.dfs.calculatorapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    var operation: MutableLiveData<String> = MutableLiveData("")

    fun addToOperation(value: String) {
        operation.value += value
    }
}