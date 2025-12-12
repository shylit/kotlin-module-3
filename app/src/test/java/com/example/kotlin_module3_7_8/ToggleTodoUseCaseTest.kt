package com.example.kotlin_module3_7_8

import com.example.kotlin_module3_7_8.domain.model.TodoItem
import com.example.kotlin_module3_7_8.domain.usecase.ToggleTodoUseCase
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class ToggleTodoUseCaseTest {

    @Test
    fun toggleTodo_changesIsCompleted() = runTest {
        val repo = FakeTodoRepository(
            listOf(
                TodoItem(1, "A", "A", false),
                TodoItem(2, "B", "B", true),
                TodoItem(3, "C", "C", false),
            )
        )
        val useCase = ToggleTodoUseCase(repo)

        // было false
        assertFalse(repo.getTodoById(1)!!.isCompleted)

        useCase(1)

        // стало true
        assertTrue(repo.getTodoById(1)!!.isCompleted)
    }
}