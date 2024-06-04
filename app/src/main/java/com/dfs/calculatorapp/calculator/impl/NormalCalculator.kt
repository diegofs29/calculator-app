package com.dfs.calculatorapp.calculator.impl

import com.dfs.calculatorapp.calculator.Calculator

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
        return if (n1 != null && n2 != null) {
            when (operator) {
                "+" -> n1 + n2
                "-" -> n1 - n2
                "×" -> n1 * n2
                "÷" -> n1 / n2
                else -> 0.0
            }
        } else if (n1 != null) {
            when (operator) {
                else -> 0.0
            }
        } else {
            0.0
        }
    }
}