package com.example.kotlin_module3_7_8.data.model

data class TodoItemDto(
    val id: Int,
    val title: String,
    val description: String,
    val isCompleted: Boolean
)