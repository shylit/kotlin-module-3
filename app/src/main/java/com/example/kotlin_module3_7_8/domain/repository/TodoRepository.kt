package com.example.kotlin_module3_7_8.domain.repository

import com.example.kotlin_module3_7_8.domain.model.TodoItem

interface TodoRepository {
    suspend fun getTodos(): List<TodoItem>
    suspend fun toggleTodo(id: Int)
    suspend fun getTodoById(id: Int): TodoItem?
}