package com.dfs.calculatorapp.calculator.impl

import com.dfs.calculatorapp.calculator.Calculator
import kotlin.math.pow
import kotlin.math.sqrt

class NormalCalculator : Calculator {
    private var number1: Double? = null
    private var operator: String? = null
    private var number2: Double? = null
    override fun setNumber1(number: Double) {
        number1 = number
    }

    override fun setNumber2(number: Double) {
        number2 = number
    }

    override fun setOperator(operator: String) {
        this.operator = operator
    }

    override fun calculate(): Double {
        val n1 = number1
        val n2 = number2
        number1 = null
        number2 = null
        return if (n1 != null && n2 != null) {
            calculateTwoNumbers(n1, n2)
        } else if (n1 != null) {
            calculateOneNumber(n1)
        } else {
            0.0
        }
    }

    private fun calculateOneNumber(n: Double): Double {
        return when (operator) {
            "-" -> -n
            "inv" -> 1 / n
            "sq" -> n.pow(2)
            "sqrt" -> sqrt(n)
            "%" -> n / 100
            else -> 0.0
        }
    }

    private fun calculateTwoNumbers(n1: Double, n2: Double): Double {
        return when (operator) {
            "+" -> n1 + n2
            "-" -> n1 - n2
            "×" -> n1 * n2
            "÷" -> n1 / n2
            else -> 0.0
        }
    }
}