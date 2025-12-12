package com.example.kotlin_module3_7_8.presentation.viewmodel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlin_module3_7_8.domain.usecase.GetTodoByIdUseCase
import com.example.kotlin_module3_7_8.domain.usecase.GetTodosUseCase
import com.example.kotlin_module3_7_8.domain.usecase.ToggleTodoUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class TodoViewModel(
    private val getTodos: GetTodosUseCase,
    private val toggleTodo: ToggleTodoUseCase,
    private val getTodoById: GetTodoByIdUseCase
) : ViewModel() {

    private val _state = MutableStateFlow<TodoUiState>(TodoUiState.Loading)
    val state: StateFlow<TodoUiState> = _state.asStateFlow()

    fun load() {
        viewModelScope.launch {
            _state.value = TodoUiState.Loading
            runCatching { getTodos() }
                .onSuccess { _state.value = TodoUiState.Content(it) }
                .onFailure { _state.value = TodoUiState.Error(it.message ?: "Unknown error") }
        }
    }

    fun onToggle(id: Int) {
        viewModelScope.launch {
            toggleTodo(id)
            // перезагрузка, чтобы UI обновился
            _state.value = TodoUiState.Content(getTodos())
        }
    }

    suspend fun getDetails(id: Int) = getTodoById(id)
}