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
        assertEquals(3.0, calculator.number1)
    }

    @Test fun setNumber1_oneDecimal() {
        calculator.setNumber1(3.1)
        assertEquals(3.1, calculator.number1)
    }

    @Test fun setNumber1_twoDecimals() {
        calculator.setNumber1(3.14)
        assertEquals(3.14, calculator.number1)
    }

    @Test fun setNumber1_threeDecimals() {
        calculator.setNumber1(3.141)
        assertEquals(3.141, calculator.number1)
    }

    @Test fun setNumber1_fourDecimals() {
        calculator.setNumber1(3.1416)
        assertEquals(3.1416, calculator.number1)
    }

    @Test fun setNumber2_zeroDecimals() {
        calculator.setNumber2(1.0)
        assertEquals(1.0, calculator.number2)
    }

    @Test fun setNumber2_oneDecimal() {
        calculator.setNumber2(1.2)
        assertEquals(1.2, calculator.number2)
    }

    @Test fun setNumber2_twoDecimals() {
        calculator.setNumber2(1.23)
        assertEquals(1.23, calculator.number2)
    }

    @Test fun setNumber2_threeDecimals() {
        calculator.setNumber2(1.234)
        assertEquals(1.234, calculator.number2)
    }

    @Test fun setNumber2_fourDecimals() {
        calculator.setNumber2(1.2345)
        assertEquals(1.2345, calculator.number2)
    }

    @Test fun setOperator_division() {
        calculator.setOperator("÷")
        assertEquals("÷", calculator.operator)
    }

    @Test fun setOperator_multiply() {
        calculator.setOperator("×")
        assertEquals("×", calculator.operator)
    }

    @Test fun setOperator_minus() {
        calculator.setOperator("-")
        assertEquals("-", calculator.operator)
    }

    @Test fun setOperator_plus() {
        calculator.setOperator("+")
        assertEquals("+", calculator.operator)
    }

    @Test fun setOperator_percentage() {
        calculator.setOperator("%")
        assertEquals("%", calculator.operator)
    }

    @Test fun setOperator_sqrt() {
        calculator.setOperator("sqrt")
        assertEquals("sqrt", calculator.operator)
    }

    @Test fun setOperator_sq() {
        calculator.setOperator("sq")
        assertEquals("sq", calculator.operator)
    }

    @Test fun setOperator_inv() {
        calculator.setOperator("inv")
        assertEquals("inv", calculator.operator)
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
        assertEquals(0.0, result, 0.0)
    }

    @Test fun calculateError_noNumber2() {
        calculator = NormalCalculator()
        calculator.setNumber1(0.1)
        calculator.setOperator("×")
        val result = calculator.calculate()
        assertEquals(0.0, result, 0.0)
    }

    @Test fun calculateError_noNumber1() {
        calculator = NormalCalculator()
        calculator.setOperator("+")
        calculator.setNumber2(0.1)
        val result = calculator.calculate()
        assertEquals(0.0, result, 0.0)
    }

    @Test fun calculate_add_bothPositive() {
        calculator.setOperator("+")
        calculator.setNumber1(25.0)
        calculator.setNumber2(25.666)
        val result: Double = calculator.calculate()
        assertEquals(50.666, result, 0.001)
    }

    @Test fun calculate_add_positiveNegativeEqualPositive() {
        calculator.setOperator("+")
        calculator.setNumber1(66.666)
        calculator.setNumber2(-40.25)
        val result = calculator.calculate()
        assertEquals(26.416, result, 0.001)
    }

    @Test fun calculate_add_positiveNegativeEqualNegative() {
        calculator.setOperator("+")
        calculator.setNumber1(25.10)
        calculator.setNumber2(-40.25)
        val result = calculator.calculate()
        assertEquals(-15.15, result, 0.01)
    }

    @Test fun calculate_add_positiveNegativeEqualZero() {
        calculator.setOperator("+")
        calculator.setNumber1(2.0)
        calculator.setNumber2(-2.0)
        val result = calculator.calculate()
        assertEquals(0.0, result, 0.0)
    }

    @Test fun calculate_add_negativePositiveEqualPositive() {
        calculator.setOperator("+")
        calculator.setNumber1(-2.0)
        calculator.setNumber2(4.25)
        val result = calculator.calculate()
        assertEquals(2.25, result, 0.01)
    }

    @Test fun calculate_add_negativePositiveEqualNegative() {
        calculator.setOperator("+")
        calculator.setNumber1(-1.1111)
        calculator.setNumber2(0.1111)
        val result = calculator.calculate()
        assertEquals(-1.0, result, 0.1)
    }

    @Test fun calculate_add_negativePositiveEqualZero() {
        calculator.setOperator("+")
        calculator.setNumber1(-5.5)
        calculator.setNumber2(5.5)
        val result = calculator.calculate()
        assertEquals(0.0, result, 0.0)
    }

    @Test fun calculate_add_bothNegative() {
        calculator.setOperator("+")
        calculator.setNumber1(-1.1111)
        calculator.setNumber2(-50.314)
        val result = calculator.calculate()
        assertEquals(-51.4251, result, 0.0001)
    }

    @Test fun calculate_add_zeroPositive() {
        calculator.setOperator("+")
        calculator.setNumber1(0.0)
        calculator.setNumber2(5.5)
        val result = calculator.calculate()
        assertEquals(5.5, result, 0.1)
    }

    @Test fun calculate_add_zeroNegative() {
        calculator.setOperator("+")
        calculator.setNumber1(0.0)
        calculator.setNumber2(-78947.416)
        val result = calculator.calculate()
        assertEquals(-78947.416, result, 0.001)
    }

    @Test fun calculate_add_positiveZero() {
        calculator.setOperator("+")
        calculator.setNumber1(564.4856)
        calculator.setNumber2(0.0)
        val result = calculator.calculate()
        assertEquals(564.4856, result, 0.0001)
    }

    @Test fun calculate_add_negativeZero() {
        calculator.setOperator("+")
        calculator.setNumber1(-461.456)
        calculator.setNumber2(0.0)
        val result = calculator.calculate()
        assertEquals(-461.456, result, 0.001)
    }

    @Test fun calculate_add_bothZero() {
        calculator.setOperator("+")
        calculator.setNumber1(0.0)
        calculator.setNumber2(0.0)
        val result = calculator.calculate()
        assertEquals(0.0, result, 0.1)
    }

    @Test fun calculate_subtract_bothPositiveEqualPositive() {
        calculator.setOperator("-")
        calculator.setNumber1(2.0)
        calculator.setNumber2(1.15)
        val result = calculator.calculate()
        assertEquals(0.85, result, 0.01)
    }

    @Test fun calculate_subtract_bothPositiveEqualNegative() {
        calculator.setOperator("-")
        calculator.setNumber1(0.231)
        calculator.setNumber2(596.7)
        val result = calculator.calculate()
        assertEquals(-596.469, result, 0.001)
    }

    @Test fun calculate_subtract_bothPositiveEqualZero() {
        calculator.setOperator("-")
        calculator.setNumber1(64.645)
        calculator.setNumber2(64.645)
        val result = calculator.calculate()
        assertEquals(0.0, result, 0.0)
    }

    @Test fun calculate_subtract_positiveNegative() {
        calculator.setOperator("-")
        calculator.setNumber1(69.87)
        calculator.setNumber2(-45.1234)
        val result = calculator.calculate()
        assertEquals(114.9934, result, 0.0001)
    }

    @Test fun calculate_subtract_negativePositive() {
        calculator.setOperator("-")
        calculator.setNumber1(-4563.654)
        calculator.setNumber2(87.456)
        val result = calculator.calculate()
        assertEquals(-4651.11, result, 0.01)
    }

    @Test fun calculate_subtract_bothNegativeEqualPositive() {
        calculator.setOperator("-")
        calculator.setNumber1(-58.12)
        calculator.setNumber2(-89.1549)
        val result = calculator.calculate()
        assertEquals(31.0349, result, 0.0001)
    }

    @Test fun calculate_subtract_bothNegativeEqualNegative() {
        calculator.setOperator("-")
        calculator.setNumber1(-9784.846)
        calculator.setNumber2(-43.64)
        val result = calculator.calculate()
        assertEquals(-9741.206, result, 0.001)
    }

    @Test fun calculate_subtract_bothNegativeEqualZero() {
        calculator.setOperator("-")
        calculator.setNumber1(-25.0)
        calculator.setNumber2(-25.0)
        val result = calculator.calculate()
        assertEquals(0.0, result, 0.0)
    }

    @Test fun calculate_subtract_zeroPositive() {
        calculator.setOperator("-")
        calculator.setNumber1(0.0)
        calculator.setNumber2(456.7)
        val result = calculator.calculate()
        assertEquals(-456.7, result, 0.1)
    }

    @Test fun calculate_subtract_zeroNegative() {
        calculator.setOperator("-")
        calculator.setNumber1(0.0)
        calculator.setNumber2(-75.123)
        val result = calculator.calculate()
        assertEquals(75.123, result, 0.001)
    }

    @Test fun calculate_subtract_positiveZero() {
        calculator.setOperator("-")
        calculator.setNumber1(21.2)
        calculator.setNumber2(0.0)
        val result = calculator.calculate()
        assertEquals(21.2, result, 0.1)
    }

    @Test fun calculate_subtract_negativeZero() {
        calculator.setOperator("-")
        calculator.setNumber1(-55.5555)
        calculator.setNumber2(0.0)
        val result = calculator.calculate()
        assertEquals(-55.5555, result, 0.0001)
    }

    @Test fun calculate_subtract_bothZero() {
        calculator.setOperator("-")
        calculator.setNumber1(0.0)
        calculator.setNumber2(0.0)
        val result = calculator.calculate()
        assertEquals(0.0, result, 0.0)
    }

    @Test fun calculate_multiply_bothPositive() {
        calculator.setOperator("×")
        calculator.setNumber1(2.2)
        calculator.setNumber2(5.4)
        val result = calculator.calculate()
        assertEquals(11.88, result, 0.01)
    }
    @Test fun calculate_multiply_positiveNegative() {
        calculator.setOperator("×")
        calculator.setNumber1(486.789)
        calculator.setNumber2(-687.985)
        val result = calculator.calculate()
        assertEquals(-334903.5301, result, 0.0001)
    }

    @Test fun calculate_multiply_negativePositive() {
        calculator.setOperator("×")
        calculator.setNumber1(-25.0)
        calculator.setNumber2(69.666)
        val result = calculator.calculate()
        assertEquals(-1741.65, result, 0.01)
    }

    @Test fun calculate_multiply_bothNegative() {
        calculator.setOperator("×")
        calculator.setNumber1(-59.48)
        calculator.setNumber2(-566.258)
        val result = calculator.calculate()
        assertEquals(33681.0258, result, 0.0001)
    }

    @Test fun calculate_multiply_zeroPositive() {
        calculator.setOperator("×")
        calculator.setNumber1(0.0)
        calculator.setNumber2(69.666)
        val result = calculator.calculate()
        assertEquals(0.0, result, 0.0)
    }

    @Test fun calculate_multiply_zeroNegative() {
        calculator.setOperator("×")
        calculator.setNumber1(0.0)
        calculator.setNumber2(-586.99)
        val result = calculator.calculate()
        assertEquals(0.0, result, 0.0)
    }

    @Test fun calculate_multiply_positiveZero() {
        calculator.setOperator("×")
        calculator.setNumber1(982.47)
        calculator.setNumber2(0.0)
        val result = calculator.calculate()
        assertEquals(0.0, result, 0.0)
    }

    @Test fun calculate_multiply_negativeZero() {
        calculator.setOperator("×")
        calculator.setNumber1(-128.52)
        calculator.setNumber2(0.0)
        val result = calculator.calculate()
        assertEquals(0.0, result, 0.0)
    }

    @Test fun calculate_multiply_bothZero() {
        calculator.setOperator("×")
        calculator.setNumber1(0.0)
        calculator.setNumber2(0.0)
        val result = calculator.calculate()
        assertEquals(0.0, result, 0.0)
    }

    @Test fun calculate_divide_bothPositive() {
        calculator.setOperator("÷")
        calculator.setNumber1(6.6)
        calculator.setNumber2(3.3)
        val result = calculator.calculate()
        assertEquals(2.0, result, 0.1)
    }

    @Test fun calculate_divide_positiveNegative() {
        calculator.setOperator("÷")
        calculator.setNumber1(841.21)
        calculator.setNumber2(-86.1)
        val result = calculator.calculate()
        assertEquals(-9.7701, result, 0.0001)
    }

    @Test fun calculate_divide_negativePositive() {
        calculator.setOperator("÷")
        calculator.setNumber1(-618.25)
        calculator.setNumber2(4.267)
        val result = calculator.calculate()
        assertEquals(-144.8910, result, 0.0001)
    }

    @Test fun calculate_divide_bothNegative() {
        calculator.setOperator("÷")
        calculator.setNumber1(-20.0)
        calculator.setNumber2(-2.0)
        val result = calculator.calculate()
        assertEquals(10.0, result, 0.1)
    }

    @Test fun calculate_divide_zeroPositive() {
        calculator.setOperator("÷")
        calculator.setNumber1(0.0)
        calculator.setNumber2(1.1)
        val result = calculator.calculate()
        assertEquals(0.0, result, 0.0)
    }

    @Test fun calculate_divide_zeroNegative() {
        calculator.setOperator("÷")
        calculator.setNumber1(0.0)
        calculator.setNumber2(-58.514)
        val result = calculator.calculate()
        assertEquals(0.0, result, 0.0)
    }

    @Test fun calculate_divide_error_positiveZero() {
        calculator.setOperator("÷")
        calculator.setNumber1(1.56)
        calculator.setNumber2(0.0)
        val result = calculator.calculate()
        assertEquals(Double.POSITIVE_INFINITY, result, 0.0)
    }

    @Test fun calculate_divide_error_negativeZero() {
        calculator.setOperator("÷")
        calculator.setNumber1(-2.78)
        calculator.setNumber2(0.0)
        val result = calculator.calculate()
        assertEquals(Double.NEGATIVE_INFINITY, result, 0.0)
    }

    @Test fun calculate_divide_error_bothZero() {
        calculator.setOperator("÷")
        calculator.setNumber1(0.0)
        calculator.setNumber2(0.0)
        val result = calculator.calculate()
        assertEquals(Double.NaN, result, 0.0)
    }

    @Test fun calculate_negative_fromPositive() {
        calculator.setOperator("-")
        calculator.setNumber1(1.0)
        val result = calculator.calculate()
        assertEquals(-1.0, result, 0.1)
    }

    @Test fun calculate_negative_fromNegative() {
        calculator.setOperator("-")
        calculator.setNumber1(-1.0)
        val result = calculator.calculate()
        assertEquals(1.0, result, 0.1)
    }

    @Test fun calculate_negative_fromZero() {
        calculator.setOperator("-")
        calculator.setNumber1(0.0)
        val result = calculator.calculate()
        assertEquals(0.0, result, 0.0)
    }

    @Test fun calculate_inverse_positive() {
        calculator.setOperator("inv")
        calculator.setNumber1(2.0)
        val result = calculator.calculate()
        assertEquals(0.5, result, 0.1)
    }

    @Test fun calculate_inverse_negative() {
        calculator.setOperator("inv")
        calculator.setNumber1(-4.0)
        val result = calculator.calculate()
        assertEquals(-0.25, result, 0.01)
    }

    @Test fun calculate_inverse_zero() {
        calculator.setOperator("inv")
        calculator.setNumber1(0.0)
        val result = calculator.calculate()
        assertEquals(Double.POSITIVE_INFINITY, result, 0.0)
    }

    @Test fun calculate_square_positive() {
        calculator.setOperator("sq")
        calculator.setNumber1(4.5)
        val result = calculator.calculate()
        assertEquals(20.25, result, 0.01)
    }

    @Test fun calculate_square_negative() {
        calculator.setOperator("sq")
        calculator.setNumber1(-3.0)
        val result = calculator.calculate()
        assertEquals(9.0, result, 0.1)
    }

    @Test fun calculate_square_zero() {
        calculator.setOperator("sq")
        calculator.setNumber1(0.0)
        val result = calculator.calculate()
        assertEquals(0.0, result, 0.0)
    }

    @Test fun calculate_squareRoot_positive() {
        calculator.setOperator("sqrt")
        calculator.setNumber1(49.0)
        val result = calculator.calculate()
        assertEquals(7.0, result, 0.1)
    }

    @Test fun calculate_squareRoot_zero() {
        calculator.setOperator("sqrt")
        calculator.setNumber1(0.0)
        val result = calculator.calculate()
        assertEquals(0.0, result, 0.0)
    }

    @Test fun calculate_squareRoot_negative() {
        calculator.setOperator("sqrt")
        calculator.setNumber1(-4.0)
        val result = calculator.calculate()
        assertEquals(Double.NaN, result, 0.0)
    }

    /*
    @Test fun calculate_percentage() {
        calculator.setOperator("%")

        // +

        // -

        // 0
    } */
}