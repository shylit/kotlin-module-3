package com.example.kotlin_module3_7_8.presentation.ui.component


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.kotlin_module3_7_8.domain.model.TodoItem
import androidx.compose.ui.platform.testTag

@Composable
fun TodoRow(
    item: TodoItem,
    onClick: () -> Unit,
    onToggle: (Int) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .testTag("todo_row_${item.id}")
            .clickable { onClick() }
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            modifier = Modifier.testTag("todo_checkbox_${item.id}"),
            checked = item.isCompleted,
            onCheckedChange = { onToggle(item.id) }
        )
        Spacer(Modifier.width(12.dp))
        Column {
            Text(item.title, style = MaterialTheme.typography.titleMedium)
            Spacer(Modifier.height(4.dp))
            Text(item.description, style = MaterialTheme.typography.bodyMedium)
        }
    }
}