package com.example.kotlin_module3_7_8

import com.example.kotlin_module3_7_8.domain.model.TodoItem
import com.example.kotlin_module3_7_8.domain.repository.TodoRepository

class FakeTodoRepository(
    initial: List<TodoItem>
) : TodoRepository {

    private val items = initial.toMutableList()

    override suspend fun getTodos(): List<TodoItem> = items.toList()

    override suspend fun toggleTodo(id: Int) {
        val idx = items.indexOfFirst { it.id == id }
        if (idx != -1) {
            val old = items[idx]
            items[idx] = old.copy(isCompleted = !old.isCompleted)
        }
    }

    override suspend fun getTodoById(id: Int): TodoItem? =
        items.firstOrNull { it.id == id }
}