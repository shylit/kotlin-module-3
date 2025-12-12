package com.example.kotlin_module3_7_8

import com.example.kotlin_module3_7_8.domain.model.TodoItem
import com.example.kotlin_module3_7_8.domain.usecase.GetTodosUseCase
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class GetTodosUseCaseTest {

    @Test
    fun getTodos_returns3Items() = runTest {
        val repo = FakeTodoRepository(
            listOf(
                TodoItem(1, "A", "A", false),
                TodoItem(2, "B", "B", true),
                TodoItem(3, "C", "C", false),
            )
        )
        val useCase = GetTodosUseCase(repo)

        val result = useCase()

        assertEquals(3, result.size)
    }
}