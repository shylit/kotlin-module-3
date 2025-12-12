package com.example.kotlin_module3_7_8.presentation.viewmodel

import com.example.kotlin_module3_7_8.domain.model.TodoItem

sealed interface TodoUiState {
    data object Loading : TodoUiState
    data class Content(val todos: List<TodoItem>) : TodoUiState
    data class Error(val message: String) : TodoUiState
}