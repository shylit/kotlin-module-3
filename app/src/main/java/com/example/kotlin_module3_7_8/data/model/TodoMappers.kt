package com.example.kotlin_module3_7_8.data.model

import com.example.kotlin_module3_7_8.domain.model.TodoItem

fun TodoItemDto.toDomain(): TodoItem =
    TodoItem(id, title, description, isCompleted)

fun TodoItem.toDto(): TodoItemDto =
    TodoItemDto(id, title, description, isCompleted)