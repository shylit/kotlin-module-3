package com.example.kotlin_module3_7_8.presentation.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.kotlin_module3_7_8.presentation.viewmodel.TodoViewModel

@Composable
fun TodoDetailScreen(
    id: Int,
    vm: TodoViewModel
) {
    var text by remember { mutableStateOf("Загрузка...") }

    LaunchedEffect(id) {
        val item = vm.getDetails(id)
        text = if (item == null) "Задача не найдена"
        else "Задача #${item.id}\n\n${item.title}\n\n${item.description}\n\nСтатус: ${if (item.isCompleted) "Выполнено" else "Не выполнено"}"
    }

    Text(
        text = text,
        modifier = Modifier.padding(16.dp)
    )
}