package com.dfs.calculatorapp


import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

class MainActivityTest {

    @Rule
    @JvmField
    var mActivityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun mainActivity_KeyboardFragment_Press0WriteToResult() {
        onView(withId(R.id.keyboard_button_0))
            .perform(click())
        onView(withId(R.id.result_text_view_result))
            .check(matches(withText("0")))
    }
    @Test
    fun mainActivity_KeyboardFragment_Press1WriteToResult() {
        onView(withId(R.id.keyboard_button_1))
            .perform(click())
        onView(withId(R.id.result_text_view_result))
            .check(matches(withText("1")))
    }
    @Test
    fun mainActivity_KeyboardFragment_Press2WriteToResult() {
        onView(withId(R.id.keyboard_button_2))
            .perform(click())
        onView(withId(R.id.result_text_view_result))
            .check(matches(withText("2")))
    }
    @Test
    fun mainActivity_KeyboardFragment_Press3WriteToResult() {
        onView(withId(R.id.keyboard_button_3))
            .perform(click())
        onView(withId(R.id.result_text_view_result))
            .check(matches(withText("3")))
    }
    @Test
    fun mainActivity_KeyboardFragment_Press4WriteToResult() {
        onView(withId(R.id.keyboard_button_4))
            .perform(click())
        onView(withId(R.id.result_text_view_result))
            .check(matches(withText("4")))
    }
    @Test
    fun mainActivity_KeyboardFragment_Press5WriteToResult() {
        onView(withId(R.id.keyboard_button_5))
            .perform(click())
        onView(withId(R.id.result_text_view_result))
            .check(matches(withText("5")))
    }
    @Test
    fun mainActivity_KeyboardFragment_Press6WriteToResult() {
        onView(withId(R.id.keyboard_button_6))
            .perform(click())
        onView(withId(R.id.result_text_view_result))
            .check(matches(withText("6")))
    }
    @Test
    fun mainActivity_KeyboardFragment_Press7WriteToResult() {
        onView(withId(R.id.keyboard_button_7))
            .perform(click())
        onView(withId(R.id.result_text_view_result))
            .check(matches(withText("7")))
    }
    @Test
    fun mainActivity_KeyboardFragment_Press8WriteToResult() {
        onView(withId(R.id.keyboard_button_8))
            .perform(click())
        onView(withId(R.id.result_text_view_result))
            .check(matches(withText("8")))
    }
    @Test
    fun mainActivity_KeyboardFragment_Press9WriteToResult() {
        onView(withId(R.id.keyboard_button_9))
            .perform(click())
        onView(withId(R.id.result_text_view_result))
            .check(matches(withText("9")))
    }

    @Test
    fun mainActivity_KeyboardFragment_WriteDecimalNumber() {
        onView(withId(R.id.keyboard_button_3))
            .perform(click())
        onView(withId(R.id.keyboard_button_decimal))
            .perform(click())
        onView(withId(R.id.keyboard_button_1))
            .perform(click())
        onView(withId(R.id.keyboard_button_4))
            .perform(click())
        onView(withId(R.id.result_text_view_result))
            .check(matches(withText("3.14")))
    }

    @Test
    fun mainActivity_KeyboardFragment_ConvertNumberToNegative() {
        onView(withId(R.id.keyboard_button_2))
            .perform(click())
        onView(withId(R.id.keyboard_button_negative))
            .perform(click())
        onView(withId(R.id.result_text_view_result))
            .check(matches(withText("-2")))
    }

    @Test
    fun mainActivity_KeyboardFragment_InverseNumber() {
        onView(withId(R.id.keyboard_button_5))
            .perform(click())
        onView(withId(R.id.keyboard_button_inverse))
            .perform(click())
        onView(withId(R.id.result_text_view_result))
            .check(matches(withText("0.2")))
    }

    @Test
    fun mainActivity_KeyboardFragment_SquareOfNumber() {
        onView(withId(R.id.keyboard_button_9))
            .perform(click())
        onView(withId(R.id.keyboard_button_square))
            .perform(click())
        onView(withId(R.id.result_text_view_result))
            .check(matches(withText("81")))
    }

    @Test
    fun mainActivity_KeyboardFragment_SquareRootOfNumber() {
        onView(withId(R.id.keyboard_button_4))
            .perform(click())
        onView(withId(R.id.keyboard_button_9))
            .perform(click())
        onView(withId(R.id.keyboard_button_sqrt))
            .perform(click())
        onView(withId(R.id.result_text_view_result))
            .check(matches(withText("7")))
    }

    @Test
    fun mainActivity_KeyboardFragment_PercentageOfNumber() {
        onView(withId(R.id.keyboard_button_5))
            .perform(click())
        onView(withId(R.id.keyboard_button_0))
            .perform(click())
        onView(withId(R.id.keyboard_button_percentage))
            .perform(click())
        onView(withId(R.id.result_text_view_result))
            .check(matches(withText("0.5")))
    }

    @Test
    fun mainActivity_KeyboardFragment_CE() {
        onView(withId(R.id.keyboard_button_9))
            .perform(click())
        onView(withId(R.id.result_text_view_result))
            .check(matches(withText("9")))
        onView(withId(R.id.keyboard_button_ce))
            .perform(click())
        onView(withId(R.id.result_text_view_result))
            .check(matches(withText("0")))
    }

    @Test
    fun mainActivity_KeyboardFragment_C() {
        onView(withId(R.id.keyboard_button_9))
            .perform(click())
        onView(withId(R.id.keyboard_button_add))
            .perform(click())
        onView(withId(R.id.keyboard_button_4))
            .perform(click())
        onView(withId(R.id.keyboard_button_equals))
            .perform(click())
        onView(withId(R.id.result_text_view_operation))
            .check(matches(withText("9 + 4 =")))
        onView(withId(R.id.result_text_view_result))
            .check(matches(withText("13")))
        onView(withId(R.id.keyboard_button_c))
            .perform(click())
        onView(withId(R.id.result_text_view_operation))
            .check(matches(withText("")))
        onView(withId(R.id.result_text_view_result))
            .check(matches(withText("0")))
    }

    @Test
    fun mainActivity_KeyboardFragment_AddWithoutEquals() {
        onView(withId(R.id.keyboard_button_9))
            .perform(click())
        onView(withId(R.id.keyboard_button_add))
            .perform(click())
        onView(withId(R.id.keyboard_button_4))
            .perform(click())
        onView(withId(R.id.keyboard_button_add))
            .perform(click())
        onView(withId(R.id.result_text_view_operation))
            .check(matches(withText("13 + ")))
        onView(withId(R.id.result_text_view_result))
            .check(matches(withText("13")))
    }

    @Test
    fun mainActivity_KeyboardFragment_AddWithEquals() {
        onView(withId(R.id.keyboard_button_9))
            .perform(click())
        onView(withId(R.id.keyboard_button_add))
            .perform(click())
        onView(withId(R.id.keyboard_button_4))
            .perform(click())
        onView(withId(R.id.keyboard_button_equals))
            .perform(click())
        onView(withId(R.id.result_text_view_operation))
            .check(matches(withText("9 + 4 =")))
        onView(withId(R.id.result_text_view_result))
            .check(matches(withText("13")))
    }

    @Test
    fun mainActivity_KeyboardFragment_SubtractWithoutEquals() {
        onView(withId(R.id.keyboard_button_2))
            .perform(click())
        onView(withId(R.id.keyboard_button_subtract))
            .perform(click())
        onView(withId(R.id.keyboard_button_1))
            .perform(click())
        onView(withId(R.id.keyboard_button_subtract))
            .perform(click())
        onView(withId(R.id.result_text_view_operation))
            .check(matches(withText("1 - ")))
        onView(withId(R.id.result_text_view_result))
            .check(matches(withText("1")))
    }

    @Test
    fun mainActivity_KeyboardFragment_SubtractWithEquals() {
        onView(withId(R.id.keyboard_button_5))
            .perform(click())
        onView(withId(R.id.keyboard_button_subtract))
            .perform(click())
        onView(withId(R.id.keyboard_button_3))
            .perform(click())
        onView(withId(R.id.keyboard_button_equals))
            .perform(click())
        onView(withId(R.id.result_text_view_operation))
            .check(matches(withText("5 - 3 =")))
        onView(withId(R.id.result_text_view_result))
            .check(matches(withText("2")))
    }

    @Test
    fun mainActivity_KeyboardFragment_MultiplyWithoutEquals() {
        onView(withId(R.id.keyboard_button_7))
            .perform(click())
        onView(withId(R.id.keyboard_button_multiply))
            .perform(click())
        onView(withId(R.id.keyboard_button_3))
            .perform(click())
        onView(withId(R.id.keyboard_button_multiply))
            .perform(click())
        onView(withId(R.id.result_text_view_operation))
            .check(matches(withText("21 × ")))
        onView(withId(R.id.result_text_view_result))
            .check(matches(withText("21")))
    }

    @Test
    fun mainActivity_KeyboardFragment_MultiplyWithEquals() {
        onView(withId(R.id.keyboard_button_9))
            .perform(click())
        onView(withId(R.id.keyboard_button_multiply))
            .perform(click())
        onView(withId(R.id.keyboard_button_8))
            .perform(click())
        onView(withId(R.id.keyboard_button_equals))
            .perform(click())
        onView(withId(R.id.result_text_view_operation))
            .check(matches(withText("9 × 8 =")))
        onView(withId(R.id.result_text_view_result))
            .check(matches(withText("72")))
    }

    @Test
    fun mainActivity_KeyboardFragment_DivideWithoutEquals() {
        onView(withId(R.id.keyboard_button_2))
            .perform(click())
        onView(withId(R.id.keyboard_button_7))
            .perform(click())
        onView(withId(R.id.keyboard_button_divide))
            .perform(click())
        onView(withId(R.id.keyboard_button_9))
            .perform(click())
        onView(withId(R.id.keyboard_button_divide))
            .perform(click())
        onView(withId(R.id.result_text_view_operation))
            .check(matches(withText("3 ÷ ")))
        onView(withId(R.id.result_text_view_result))
            .check(matches(withText("3")))
    }

    @Test
    fun mainActivity_KeyboardFragment_DivideWithEquals() {
        onView(withId(R.id.keyboard_button_9))
            .perform(click())
        onView(withId(R.id.keyboard_button_divide))
            .perform(click())
        onView(withId(R.id.keyboard_button_5))
            .perform(click())
        onView(withId(R.id.keyboard_button_equals))
            .perform(click())
        onView(withId(R.id.result_text_view_operation))
            .check(matches(withText("9 ÷ 5 =")))
        onView(withId(R.id.result_text_view_result))
            .check(matches(withText("1.8")))
    }

    @Test
    fun mainActivity_KeyboardFragment_DeleteWithoutWriting() {
        onView(withId(R.id.keyboard_button_del))
            .perform(click())
        onView(withId(R.id.result_text_view_result))
            .check(matches(withText("")))
        onView(withId(R.id.keyboard_button_del))
            .perform(click())
        onView(withId(R.id.result_text_view_result))
            .check(matches(withText("")))
    }

    @Test
    fun mainActivity_KeyboardFragment_DeleteWithWriting() {
        onView(withId(R.id.keyboard_button_9))
            .perform(click())
        onView(withId(R.id.keyboard_button_del))
            .perform(click())
        onView(withId(R.id.result_text_view_result))
            .check(matches(withText("")))
    }

    @Test
    fun mainActivity_KeyboardFragment_ChangeOperators() {
        onView(withId(R.id.keyboard_button_9))
            .perform(click())
        onView(withId(R.id.keyboard_button_subtract))
            .perform(click())
        onView(withId(R.id.keyboard_button_add))
            .perform(click())
        onView(withId(R.id.result_text_view_operation))
            .check(matches(withText("9 + ")))
        onView(withId(R.id.keyboard_button_subtract))
            .perform(click())
        onView(withId(R.id.result_text_view_operation))
            .check(matches(withText("9 - ")))
        onView(withId(R.id.keyboard_button_multiply))
            .perform(click())
        onView(withId(R.id.result_text_view_operation))
            .check(matches(withText("9 × ")))
        onView(withId(R.id.keyboard_button_divide))
            .perform(click())
        onView(withId(R.id.result_text_view_operation))
            .check(matches(withText("9 ÷ ")))
    }
}
