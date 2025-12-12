package com.example.kotlin_module3_7_8.data.repository

import com.example.kotlin_module3_7_8.data.local.TodoJsonDataSource
import com.example.kotlin_module3_7_8.data.model.toDomain
import com.example.kotlin_module3_7_8.domain.model.TodoItem
import com.example.kotlin_module3_7_8.domain.repository.TodoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TodoRepositoryImpl(
    private val dataSource: TodoJsonDataSource
) : TodoRepository {

    // “локальная база” в памяти
    private var cache: MutableList<TodoItem>? = null

    override suspend fun getTodos(): List<TodoItem> = withContext(Dispatchers.IO) {
        if (cache == null) {
            cache = dataSource.loadTodos().map { it.toDomain() }.toMutableList()
        }
        cache!!.toList()
    }

    override suspend fun toggleTodo(id: Int) = withContext(Dispatchers.IO) {
        val list = (cache ?: getTodos().toMutableList()).toMutableList()
        val idx = list.indexOfFirst { it.id == id }
        if (idx != -1) {
            val old = list[idx]
            list[idx] = old.copy(isCompleted = !old.isCompleted)
            cache = list
        }
    }

    override suspend fun getTodoById(id: Int): TodoItem? = withContext(Dispatchers.IO) {
        (cache ?: getTodos()).firstOrNull { it.id == id }
    }
}