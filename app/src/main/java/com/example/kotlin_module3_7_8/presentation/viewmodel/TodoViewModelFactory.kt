package com.example.kotlin_module3_7_8.presentation.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kotlin_module3_7_8.data.local.TodoJsonDataSource
import com.example.kotlin_module3_7_8.data.repository.TodoRepositoryImpl
import com.example.kotlin_module3_7_8.domain.usecase.GetTodoByIdUseCase
import com.example.kotlin_module3_7_8.domain.usecase.GetTodosUseCase
import com.example.kotlin_module3_7_8.domain.usecase.ToggleTodoUseCase

class TodoViewModelFactory(
    private val context: Context
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val ds = TodoJsonDataSource(context)
        val repo = TodoRepositoryImpl(ds)

        val vm = TodoViewModel(
            getTodos = GetTodosUseCase(repo),
            toggleTodo = ToggleTodoUseCase(repo),
            getTodoById = GetTodoByIdUseCase(repo)
        )

        @Suppress("UNCHECKED_CAST")
        return vm as T
    }
}