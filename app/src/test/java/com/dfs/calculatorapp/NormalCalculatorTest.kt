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

    @Test fun setNumber1_zeroDecimals() {
        calculator.setNumber1(3.0)
        assertEquals(calculator.number1, 3.0)
    }

    @Test fun setNumber1_oneDecimal() {
        calculator.setNumber1(3.1)
        assertEquals(calculator.number1, 3.1)
    }

    @Test fun setNumber1_twoDecimals() {
        calculator.setNumber1(3.14)
        assertEquals(calculator.number1, 3.14)
    }

    @Test fun setNumber1_threeDecimals() {
        calculator.setNumber1(3.141)
        assertEquals(calculator.number1, 3.141)
    }

    @Test fun setNumber1_fourDecimals() {
        calculator.setNumber1(3.1416)
        assertEquals(calculator.number1, 3.1416)
    }

    @Test fun setNumber2_zeroDecimals() {
        calculator.setNumber2(1.0)
        assertEquals(calculator.number2, 1.0)
    }

    @Test fun setNumber2_oneDecimal() {
        calculator.setNumber2(1.2)
        assertEquals(calculator.number2, 1.2)
    }

    @Test fun setNumber2_twoDecimals() {
        calculator.setNumber2(1.23)
        assertEquals(calculator.number2, 1.23)
    }

    @Test fun setNumber2_threeDecimals() {
        calculator.setNumber2(1.234)
        assertEquals(calculator.number2, 1.234)
    }

    @Test fun setNumber2_fourDecimals() {
        calculator.setNumber2(1.2345)
        assertEquals(calculator.number2, 1.2345)
    }

    @Test fun setOperator_division() {
        calculator.setOperator("÷")
        assertEquals(calculator.operator, "÷")
    }

    @Test fun setOperator_multiply() {
        calculator.setOperator("×")
        assertEquals(calculator.operator, "×")
    }

    @Test fun setOperator_minus() {
        calculator.setOperator("-")
        assertEquals(calculator.operator, "-")
    }

    @Test fun setOperator_plus() {
        calculator.setOperator("+")
        assertEquals(calculator.operator, "+")
    }

    @Test fun setOperator_percentage() {
        calculator.setOperator("%")
        assertEquals(calculator.operator, "%")
    }

    @Test fun setOperator_sqrt() {
        calculator.setOperator("sqrt")
        assertEquals(calculator.operator, "sqrt")
    }

    @Test fun setOperator_sq() {
        calculator.setOperator("sq")
        assertEquals(calculator.operator, "sq")
    }

    @Test fun setOperator_inv() {
        calculator.setOperator("inv")
        assertEquals(calculator.operator, "inv")
    }

    @Test fun setOperator_isNotSet() {
        calculator.setOperator("nope")
        assertNull(calculator.operator)
    }

    @Test fun calculateError_noOperator() {
        calculator = NormalCalculator()
        calculator.setNumber1(0.1)
        calculator.setNumber2(0.2)
        val result = calculator.calculate()
        assertEquals(result, 0.0, 0.0)
    }

    @Test fun calculateError_noNumber2() {
        calculator = NormalCalculator()
        calculator.setNumber1(0.1)
        calculator.setOperator("×")
        val result = calculator.calculate()
        assertEquals(result, 0.0, 0.0)
    }

    @Test fun calculateError_noNumber1() {
        calculator = NormalCalculator()
        calculator.setOperator("+")
        calculator.setNumber2(0.1)
        val result = calculator.calculate()
        assertEquals(result, 0.0, 0.0)
    }

    @Test fun calculate_add_bothPositive() {
        calculator.setOperator("+")
        calculator.setNumber1(25.0)
        calculator.setNumber2(25.666)
        val result: Double = calculator.calculate()
        assertEquals(result, 50.666, 0.1)
    }

    @Test fun calculate_add_positiveNegativeEqualPositive() {
        calculator.setOperator("+")
        calculator.setNumber1(66.666)
        calculator.setNumber2(-40.25)
        val result = calculator.calculate()
        assertEquals(result, 26.416, 0.1)
    }

    @Test fun calculate_add_positiveNegativeEqualNegative() {
        calculator.setOperator("+")
        calculator.setNumber1(25.10)
        calculator.setNumber2(-40.25)
        val result = calculator.calculate()
        assertEquals(result, -15.15, 0.1)
    }

    @Test fun calculate_add_positiveNegativeEqualZero() {
        calculator.setOperator("+")
        calculator.setNumber1(2.0)
        calculator.setNumber2(-2.0)
        val result = calculator.calculate()
        assertEquals(result, 0.0, 0.0)
    }

    @Test fun calculate_add_negativePositiveEqualPositive() {
        calculator.setOperator("+")
        calculator.setNumber1(-2.0)
        calculator.setNumber2(4.25)
        val result = calculator.calculate()
        assertEquals(result, 2.25, 0.1)
    }

    @Test fun calculate_add_negativePositiveEqualNegative() {
        calculator.setOperator("+")
        calculator.setNumber1(-1.1111)
        calculator.setNumber2(0.1111)
        val result = calculator.calculate()
        assertEquals(result, -1.0, 0.1)
    }

    @Test fun calculate_add_negativePositiveEqualZero() {
        calculator.setOperator("+")
        calculator.setNumber1(-5.5)
        calculator.setNumber2(5.5)
        val result = calculator.calculate()
        assertEquals(result, 0.0, 0.0)
    }

    @Test fun calculate_add_bothNegative() {
        calculator.setOperator("+")
        calculator.setNumber1(-1.1111)
        calculator.setNumber2(-50.314)
        val result = calculator.calculate()
        assertEquals(result, -51.4251, 0.1)
    }

    @Test fun calculate_add_zeroPositive() {
        calculator.setOperator("+")
        calculator.setNumber1(0.0)
        calculator.setNumber2(5.5)
        val result = calculator.calculate()
        assertEquals(result, 5.5, 0.1)
    }

    @Test fun calculate_add_zeroNegative() {
        calculator.setOperator("+")
        calculator.setNumber1(0.0)
        calculator.setNumber2(-78947.416)
        val result = calculator.calculate()
        assertEquals(result, -78947.416, 0.1)
    }

    @Test fun calculate_add_positiveZero() {
        calculator.setOperator("+")
        calculator.setNumber1(564.4856)
        calculator.setNumber2(0.0)
        val result = calculator.calculate()
        assertEquals(result, 564.4856, 0.1)
    }

    @Test fun calculate_add_negativeZero() {
        calculator.setOperator("+")
        calculator.setNumber1(-461.456)
        calculator.setNumber2(0.0)
        val result = calculator.calculate()
        assertEquals(result, -461.456, 0.1)
    }

    @Test fun calculate_add_bothZero() {
        calculator.setOperator("+")
        calculator.setNumber1(0.0)
        calculator.setNumber2(0.0)
        val result = calculator.calculate()
        assertEquals(result, 0.0, 0.1)
    }

    @Test fun calculate_subtract_bothPositiveEqualPositive() {
        calculator.setOperator("-")
        calculator.setNumber1(2.0)
        calculator.setNumber2(1.15)
        val result = calculator.calculate()
        assertEquals(result, 0.85, 0.1)
    }

    @Test fun calculate_subtract_bothPositiveEqualNegative() {
        calculator.setOperator("-")
        calculator.setNumber1(0.231)
        calculator.setNumber2(596.7)
        val result = calculator.calculate()
        assertEquals(result, -596.469, 0.1)
    }

    @Test fun calculate_subtract_bothPositiveEqualZero() {
        calculator.setOperator("-")
        calculator.setNumber1(64.645)
        calculator.setNumber2(64.645)
        val result = calculator.calculate()
        assertEquals(result, 0.0, 0.0)
    }

    @Test fun calculate_subtract_positiveNegative() {
        calculator.setOperator("-")
        calculator.setNumber1(69.87)
        calculator.setNumber2(-45.1234)
        val result = calculator.calculate()
        assertEquals(result, 114.9934, 0.1)
    }

    @Test fun calculate_subtract_negativePositive() {
        calculator.setOperator("-")
        calculator.setNumber1(-4563.654)
        calculator.setNumber2(87.456)
        val result = calculator.calculate()
        assertEquals(result, -4651.11, 0.1)
    }

    @Test fun calculate_subtract_bothNegativeEqualPositive() {
        calculator.setOperator("-")
        calculator.setNumber1(-58.12)
        calculator.setNumber2(-89.1549)
        val result = calculator.calculate()
        assertEquals(result, 31.0349, 0.1)
    }

    @Test fun calculate_subtract_bothNegativeEqualNegative() {
        calculator.setOperator("-")
        calculator.setNumber1(-9784.846)
        calculator.setNumber2(-43.64)
        val result = calculator.calculate()
        assertEquals(result, -9741.209, 0.1)
    }

    @Test fun calculate_subtract_bothNegativeEqualZero() {
        calculator.setOperator("-")
        calculator.setNumber1(-25.0)
        calculator.setNumber2(-25.0)
        val result = calculator.calculate()
        assertEquals(result, 0.0, 0.0)
    }

    @Test fun calculate_subtract_zeroPositive() {
        calculator.setOperator("-")
        calculator.setNumber1(0.0)
        calculator.setNumber2(456.7)
        val result = calculator.calculate()
        assertEquals(result, -456.7, 0.1)
    }

    @Test fun calculate_subtract_zeroNegative() {
        calculator.setOperator("-")
        calculator.setNumber1(0.0)
        calculator.setNumber2(-75.123)
        val result = calculator.calculate()
        assertEquals(result, 75.123, 0.1)
    }

    @Test fun calculate_subtract_positiveZero() {
        calculator.setOperator("-")
        calculator.setNumber1(21.2)
        calculator.setNumber2(0.0)
        val result = calculator.calculate()
        assertEquals(result, 21.2, 0.1)
    }

    @Test fun calculate_subtract_negativeZero() {
        calculator.setOperator("-")
        calculator.setNumber1(-55.5555)
        calculator.setNumber2(0.0)
        val result = calculator.calculate()
        assertEquals(result, -55.5555, 0.1)
    }

    @Test fun calculate_subtract_bothZero() {
        calculator.setOperator("-")
        calculator.setNumber1(0.0)
        calculator.setNumber2(0.0)
        val result = calculator.calculate()
        assertEquals(result, 0.0, 0.0)
    }

    /*
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
    } */
}