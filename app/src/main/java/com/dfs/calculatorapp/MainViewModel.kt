package com.dfs.calculatorapp

import android.icu.text.DecimalFormat
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dfs.calculatorapp.calculator.Calculator

class MainViewModel : ViewModel() {
    var operation: MutableLiveData<String> = MutableLiveData("")
    var result: MutableLiveData<String> = MutableLiveData("0")

    lateinit var calculator: Calculator

    private var moveToOperation: Boolean = false
    private var numberList: MutableList<Double> = ArrayList()
    private var operator: String? = null

    fun addNumberToOperation(number: String) {
        if ("[0-9.]".toRegex().matches(number)) {
            if (moveToOperation) {
                moveToOperation = false
                result.value = ""
            } else if ("0+".toRegex().matches(result.value ?: "") && number != ".") {
                result.value = ""
            }
            result.value += number
        }
    }

    fun addOperatorToOperation(operator: String) {
        if (result.value?.isNotEmpty() == true) {
            if ("[+\\-×÷=]".toRegex().matches(operator)) {
                if (isLastValueOperator()) {
                    operation.value = operation.value?.dropLast(1)
                } else {
                    moveToOperation = true
                    operation.value = DecimalFormat("#.#### ").format(result.value?.toDoubleOrNull())
                    manageDoubleOperation()
                }
                operation.value += "$operator "
                this.operator = operator
            }
        }
    }

    private fun manageDoubleOperation() {
        result.value?.toDoubleOrNull()?.let { numberList.add(it) }
        if (numberList.size == 2) {
            calculator.setNumber1(numberList[0])
            calculator.setNumber2(numberList[1])
            operator?.let { calculator.setOperator(it) }
            val value = calculator.calculate().toDouble()
            this.result.value = DecimalFormat("#.####").format(value)
            this.operation.value = DecimalFormat("#.#### ").format(value)
            numberList.clear()
            numberList.add(value)
        }
    }

    private fun isLastValueOperator(): Boolean {
        operation.value?.let {
            if (it.isNotEmpty()) {
                if ("[+\\-×÷]".toRegex().matchesAt(it, it.length - 1)) {
                    return true
                }
            }
        }
        return false
    }

    fun addSingleOperatorToOperation(operator: String) {
        when (operator) {
            "-" -> manageSingleOperation("-")
            "inv" -> manageSingleOperation("inv")
            "sq" -> manageSingleOperation("sq")
            "sqrt" -> manageSingleOperation("sqrt")
            "%" -> manageSingleOperation("%")
            "CE" -> result.value = "0"
            "C" -> {
                result.value = "0"
                operation.value = ""
                numberList.clear()
                this.operator = null
            }
        }
    }

    private fun manageSingleOperation(operator: String) {
        val number = result.value?.toDoubleOrNull()
        number?.let { calculator.setNumber1(it) }
        calculator.setOperator(operator)
        val value = calculator.calculate().toDouble()
        result.value = DecimalFormat("#.####").format(value)
    }

    fun delete() {
        result.value = result.value?.dropLast(1)
    }

    fun calculate() {
        if (numberList.size == 1) {
            operation.value += DecimalFormat("#.#### ").format(result.value?.toDoubleOrNull())
            operation.value += "="
            result.value?.toDoubleOrNull()?.let { numberList.add(it) }
            if (numberList.size == 2) {
                calculator.setNumber1(numberList[0])
                calculator.setNumber2(numberList[1])
                operator?.let { calculator.setOperator(it) }
                val value = calculator.calculate().toDouble()
                this.result.value = DecimalFormat("#.####").format(value)
                numberList.clear()
            }
        }
    }
}