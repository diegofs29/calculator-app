package com.dfs.calculatorapp.calculator

interface Calculator {
    fun setNumber1(number: Double)
    fun setNumber2(number: Double)
    fun setOperator(operator: String)
    fun calculate(): Number
}