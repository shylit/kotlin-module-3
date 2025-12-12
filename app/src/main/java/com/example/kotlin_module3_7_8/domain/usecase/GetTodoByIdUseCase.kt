package com.example.kotlin_module3_7_8.domain.usecase

import com.example.kotlin_module3_7_8.domain.repository.TodoRepository

class GetTodoByIdUseCase(
    private val repository: TodoRepository
) {
    suspend operator fun invoke(id: Int) = repository.getTodoById(id)
}