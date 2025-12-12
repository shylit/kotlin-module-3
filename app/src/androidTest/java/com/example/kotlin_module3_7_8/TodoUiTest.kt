package com.example.kotlin_module3_7_8

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsOff
import androidx.compose.ui.test.assertIsOn
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test

class TodoUiTest {

    @get:Rule
    val rule = createAndroidComposeRule<MainActivity>()

    // 3) UI-тест: отображаются все 3 задачи из JSON
    @Test
    fun showsAll3TodosFromJson() {
        rule.onNodeWithText("Купить продукты").assertIsDisplayed()
        rule.onNodeWithText("Сделать практику 7").assertIsDisplayed()
        rule.onNodeWithText("Пробежка").assertIsDisplayed()
    }

    // 4) UI-тест: чекбокс переключает статус
    @Test
    fun checkboxTogglesStatus() {
        val checkbox = rule.onNodeWithTag("todo_checkbox_1")

        // предполагаем, что в JSON у id=1 isCompleted=false
        checkbox.assertIsOff()
        checkbox.performClick()
        checkbox.assertIsOn()
    }

    // 5) UI-тест: навигация List → Detail → List
    @Test
    fun navigation_list_to_detail_to_list() {
        // открыть Details по клику на строку
        rule.onNodeWithTag("todo_row_1").performClick()

        // Проверяем, что мы на экране деталей.
        // Подстрой под твой текст в TodoDetailScreen:
        rule.onNodeWithText("Задача #1").assertIsDisplayed()

        // Назад
        rule.activityRule.scenario.onActivity {
            it.onBackPressedDispatcher.onBackPressed()
        }

        // Снова список
        rule.onNodeWithText("Купить продукты").assertIsDisplayed()
    }
}