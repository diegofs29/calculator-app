package com.dfs.calculatorapp

import android.icu.text.DecimalFormat
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.mockito.Mock

class MainViewModelTest {
    private lateinit var viewModel: MainViewModel

    @Mock private lateinit var formatter: DecimalFormat

    @get:Rule var rule: TestRule = InstantTaskExecutorRule()

    @Before fun setup() {
        viewModel = MainViewModel()
        formatter = DecimalFormat("#.#### ")
    }

    @Test fun mainViewModel_AddNumberToOperation_LetterNotAdded() {
        viewModel.addNumberToOperation("a")
        assertEquals("0", viewModel.result.value)
    }

    @Test fun mainViewModel_AddNumberToOperation_NumberZeroAddedToResult() {
        viewModel.addNumberToOperation("0")
        assertEquals("0", viewModel.result.value)
    }

    @Test fun mainViewModel_AddNumberToOperation_NumberOneAddedToResult() {
        viewModel.addNumberToOperation("1")
        assertEquals("1", viewModel.result.value)
    }

    @Test fun mainViewModel_AddNumberToOperation_NumberTwoAddedToResult() {
        viewModel.addNumberToOperation("2")
        assertEquals("2", viewModel.result.value)
    }

    @Test fun mainViewModel_AddNumberToOperation_NumberThreeAddedToResult() {
        viewModel.addNumberToOperation("3")
        assertEquals("3", viewModel.result.value)
    }

    @Test fun mainViewModel_AddNumberToOperation_NumberFourAddedToResult() {
        viewModel.addNumberToOperation("4")
        assertEquals("4", viewModel.result.value)
    }

    @Test fun mainViewModel_AddNumberToOperation_NumberFiveAddedToResult() {
        viewModel.addNumberToOperation("5")
        assertEquals("5", viewModel.result.value)
    }

    @Test fun mainViewModel_AddNumberToOperation_NumberSixAddedToResult() {
        viewModel.addNumberToOperation("6")
        assertEquals("6", viewModel.result.value)
    }

    @Test fun mainViewModel_AddNumberToOperation_NumberSevenAddedToResult() {
        viewModel.addNumberToOperation("7")
        assertEquals("7", viewModel.result.value)
    }

    @Test fun mainViewModel_AddNumberToOperation_NumberEightAddedToResult() {
        viewModel.addNumberToOperation("8")
        assertEquals("8", viewModel.result.value)
    }

    @Test fun mainViewModel_AddNumberToOperation_NumberNineAddedToResult() {
        viewModel.addNumberToOperation("9")
        assertEquals("9", viewModel.result.value)
    }

    @Test fun mainViewModel_AddNumberToOperation_MultipleNumbersNotAddedToResult() {
        viewModel.addNumberToOperation("12")
        assertEquals("0", viewModel.result.value)
    }

    @Test fun mainViewModel_AddOperatorToOperation_IncorrectOperatorNotAdded() {
        viewModel.addOperatorToOperation("/")
        assertEquals(0, viewModel.operation.value?.length)
    }

    @Test fun mainViewModel_AddOperatorToOperation_PlusOperatorAddedNumberMovedUp() {
        viewModel.addOperatorToOperation("+")
        assertEquals("0 + ", viewModel.operation.value)
    }

    @Test fun mainViewModel_AddOperatorToOperation_MinusOperatorAddedNumberMovedUp() {
        viewModel.addOperatorToOperation("-")
        assertEquals("0 - ", viewModel.operation.value)
    }

    @Test fun mainViewModel_AddOperatorToOperation_MultiplyOperatorAddedNumberMovedUp() {
        viewModel.addOperatorToOperation("×")
        assertEquals("0 × ", viewModel.operation.value)
    }

    @Test fun mainViewModel_AddOperatorToOperation_DivideOperatorAddedNumberMovedUp() {
        viewModel.addOperatorToOperation("÷")
        assertEquals("0 ÷ ", viewModel.operation.value)
    }

    @Test fun mainViewModel_AddOperatorToOperation_PlusOperatorAddedAfterOtherOperator() {
        viewModel.addOperatorToOperation("-")
        viewModel.addOperatorToOperation("+")
        assertEquals("0 + ", viewModel.operation.value)
    }

    @Test fun mainViewModel_AddOperatorToOperation_MinusOperatorAddedAfterOtherOperator() {
        viewModel.addOperatorToOperation("+")
        viewModel.addOperatorToOperation("-")
        assertEquals("0 - ", viewModel.operation.value)
    }

    @Test fun mainViewModel_AddOperatorToOperation_MultiplyOperatorAddedAfterOtherOperator() {
        viewModel.addOperatorToOperation("-")
        viewModel.addOperatorToOperation("×")
        assertEquals("0 × ", viewModel.operation.value)
    }

    @Test fun mainViewModel_AddOperatorToOperation_DivideOperatorAddedAfterOtherOperator() {
        viewModel.addOperatorToOperation("-")
        viewModel.addOperatorToOperation("÷")
        assertEquals("0 ÷ ", viewModel.operation.value)
    }
}