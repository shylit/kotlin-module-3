package com.example.kotlin_module3_7_8.presentation.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.kotlin_module3_7_8.navigation.Routes
import com.example.kotlin_module3_7_8.presentation.ui.component.TodoRow
import com.example.kotlin_module3_7_8.presentation.viewmodel.TodoUiState
import com.example.kotlin_module3_7_8.presentation.viewmodel.TodoViewModel

@Composable
fun TodoListScreen(
    vm: TodoViewModel,
    onOpenDetails: (Int) -> Unit
) {
    val state = vm.state.collectAsState().value

    when (state) {
        is TodoUiState.Loading -> Text("Загрузка...", modifier = Modifier.padding(16.dp))
        is TodoUiState.Error -> Text("Ошибка: ${state.message}", modifier = Modifier.padding(16.dp))
        is TodoUiState.Content -> {
            LazyColumn(contentPadding = PaddingValues(8.dp)) {
                items(state.todos) { item ->
                    TodoRow(
                        item = item,
                        onClick = { onOpenDetails(item.id) },
                        onToggle = { vm.onToggle(it) }
                    )
                }
            }
        }
    }
}