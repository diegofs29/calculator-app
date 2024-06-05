package com.dfs.calculatorapp

import com.dfs.calculatorapp.calculator.impl.NormalCalculator
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class NormalCalculatorTest {
    private lateinit var calculator: NormalCalculator

    @Before fun setup() {
        calculator = NormalCalculator()
    }

    @Test fun setNumber1() {
        calculator.setNumber1(3.1416)
        assertEquals(calculator.number1, 3.1416)
        calculator.setNumber1(3.141)
        assertEquals(calculator.number1, 3.141)
        calculator.setNumber1(3.14)
        assertEquals(calculator.number1, 3.14)
        calculator.setNumber1(3.1)
        assertEquals(calculator.number1, 3.1)
        calculator.setNumber1(3.0)
        assertEquals(calculator.number1, 3.0)
    }

    @Test fun setNumber2() {
        calculator.setNumber2(1.2345)
        assertEquals(calculator.number2, 1.2345)
        calculator.setNumber2(1.234)
        assertEquals(calculator.number2, 1.234)
        calculator.setNumber2(1.23)
        assertEquals(calculator.number2, 1.23)
        calculator.setNumber2(1.2)
        assertEquals(calculator.number2, 1.2)
        calculator.setNumber2(1.0)
        assertEquals(calculator.number2, 1.0)
    }

    @Test fun setOperator_isSet() {
        calculator.setOperator("inv")
        assertEquals(calculator.operator, "inv")
        calculator.setOperator("sq")
        assertEquals(calculator.operator, "sq")
        calculator.setOperator("sqrt")
        assertEquals(calculator.operator, "sqrt")
        calculator.setOperator("%")
        assertEquals(calculator.operator, "%")
        calculator.setOperator("+")
        assertEquals(calculator.operator, "+")
        calculator.setOperator("-")
        assertEquals(calculator.operator, "-")
        calculator.setOperator("×")
        assertEquals(calculator.operator, "×")
        calculator.setOperator("÷")
        assertEquals(calculator.operator, "÷")
    }

    @Test fun setOperator_isNotSet() {
        calculator.setOperator("nope")
        assertNull(calculator.operator)
    }

    @Test fun calculate_error() {
        // n1 null
        calculator = NormalCalculator()
        calculator.setOperator("+")
        calculator.setNumber2(0.1)
        var result = calculator.calculate()
        assertEquals(result, 0.0, 0.0)
        // n2 null and needed
        calculator = NormalCalculator()
        calculator.setNumber1(0.1)
        calculator.setOperator("×")
        result = calculator.calculate()
        assertEquals(result, 0.0, 0.0)
        // op fail
        calculator = NormalCalculator()
        calculator.setNumber1(0.1)
        calculator.setNumber2(0.2)
        result = calculator.calculate()
        assertEquals(result, 0.0, 0.0)
    }

    @Test fun calculate_add() {
        calculator.setOperator("+")

        // ++
        calculator.setNumber1(25.0)
        calculator.setNumber2(25.666)
        var result: Double = calculator.calculate()
        assertEquals(result, 50.666, 0.1)

        // +- = +
        calculator.setNumber1(66.666)
        calculator.setNumber2(-40.25)
        result = calculator.calculate()
        assertEquals(result, 26.416, 0.1)

        // +- = -
        calculator.setNumber1(25.10)
        calculator.setNumber2(-40.25)
        result = calculator.calculate()
        assertEquals(result, -15.15, 0.1)

        // +- = 0
        calculator.setNumber1(2.0)
        calculator.setNumber2(-2.0)
        result = calculator.calculate()
        assertEquals(result, 0.0, 0.0)

        // -+ = +
        calculator.setNumber1(-2.0)
        calculator.setNumber2(4.25)
        result = calculator.calculate()
        assertEquals(result, 2.25, 0.1)

        // -+ = -
        calculator.setNumber1(-1.1111)
        calculator.setNumber2(0.1111)
        result = calculator.calculate()
        assertEquals(result, -1.0, 0.1)

        // -+ = 0
        calculator.setNumber1(-5.5)
        calculator.setNumber2(5.5)
        result = calculator.calculate()
        assertEquals(result, 0.0, 0.1)

        // --
        calculator.setNumber1(-1.1111)
        calculator.setNumber2(-50.314)
        result = calculator.calculate()
        assertEquals(result, -51.4251, 0.1)

        // 0+
        calculator.setNumber1(0.0)
        calculator.setNumber2(5.5)
        result = calculator.calculate()
        assertEquals(result, 5.5, 0.1)

        // 0-
        calculator.setNumber1(0.0)
        calculator.setNumber2(-78947.416)
        result = calculator.calculate()
        assertEquals(result, -78947.416, 0.1)

        // +0
        calculator.setNumber1(564.4856)
        calculator.setNumber2(0.0)
        result = calculator.calculate()
        assertEquals(result, 564.4856, 0.1)

        // -0
        calculator.setNumber1(-461.456)
        calculator.setNumber2(0.0)
        result = calculator.calculate()
        assertEquals(result, -461.456, 0.1)

        // 00
        calculator.setNumber1(0.0)
        calculator.setNumber2(0.0)
        result = calculator.calculate()
        assertEquals(result, 0.0, 0.1)
    }

    @Test fun calculate_subtract() {
        calculator.setOperator("-")

        // ++ = +
        calculator.setNumber1(2.0)
        calculator.setNumber2(1.15)
        var result = calculator.calculate()
        assertEquals(result, 0.85, 0.1)

        // ++ = -
        calculator.setNumber1(0.231)
        calculator.setNumber2(596.7)
        result = calculator.calculate()
        assertEquals(result, -596.469, 0.1)

        // ++ = 0
        calculator.setNumber1(64.645)
        calculator.setNumber2(64.645)
        result = calculator.calculate()
        assertEquals(result, 0.0, 0.0)

        // +-
        calculator.setNumber1(69.87)
        calculator.setNumber2(-45.1234)
        result = calculator.calculate()
        assertEquals(result, 114.9934, 0.1)

        // -+
        calculator.setNumber1(-4563.654)
        calculator.setNumber2(87.456)
        result = calculator.calculate()
        assertEquals(result, -4651.11, 0.1)

        // -- = +
        calculator.setNumber1(-58.12)
        calculator.setNumber2(-89.1549)
        result = calculator.calculate()
        assertEquals(result, 31.0349, 0.1)

        // -- = -
        calculator.setNumber1(-9784.846)
        calculator.setNumber2(-43.64)
        result = calculator.calculate()
        assertEquals(result, -9741.209, 0.1)

        // -- = 0
        calculator.setNumber1(-25.0)
        calculator.setNumber2(-25.0)
        result = calculator.calculate()
        assertEquals(result, 0.0, 0.0)

        // 0+
        calculator.setNumber1(0.0)
        calculator.setNumber2(456.7)
        result = calculator.calculate()
        assertEquals(result, -456.7, 0.1)

        // 0-
        calculator.setNumber1(0.0)
        calculator.setNumber2(-75.123)
        result = calculator.calculate()
        assertEquals(result, 75.123, 0.1)

        // +0
        calculator.setNumber1(21.2)
        calculator.setNumber2(0.0)
        result = calculator.calculate()
        assertEquals(result, 21.2, 0.1)

        // -0
        calculator.setNumber1(-55.5555)
        calculator.setNumber2(0.0)
        result = calculator.calculate()
        assertEquals(result, -55.5555, 0.1)

        // 00
        calculator.setNumber1(0.0)
        calculator.setNumber2(0.0)
        result = calculator.calculate()
        assertEquals(result, 0.0, 0.0)
    }

    @Test fun calculate_multiply() {
        calculator.setOperator("×")

        // ++

        // +-

        // -+

        // --

        // 0+

        // 0-

        // +0

        // -0

        // 00

    }

    @Test fun calculate_divide() {
        calculator.setOperator("÷")

        // ++

        // +-

        // -+

        // --

        // 0+

        // 0-
    }

    @Test fun calculate_divide_error() {
        calculator.setOperator("÷")

        // +0

        // -0

        // 00
    }

    @Test fun calculate_negative() {
        calculator.setOperator("-")

        // +

        // -

        // 0
    }

    @Test fun calculate_inverse() {
        calculator.setOperator("inv")

        // +

        // -
    }

    @Test fun calculate_inverse_error() {
        calculator.setOperator("inv")

        // 0
    }

    @Test fun calculate_square() {
        calculator.setOperator("sq")

        // +

        // -

        // 0
    }

    @Test fun calculate_squareRoot() {
        calculator.setOperator("sqrt")

        // +

        // 0
    }

    @Test fun calculate_squareRoot_error() {
        calculator.setOperator("sqrt")

        // -
    }

    @Test fun calculate_percentage() {
        calculator.setOperator("%")

        // +

        // -

        // 0
    }
}