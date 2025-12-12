package com.example.kotlin_module3_7_8.domain.model

data class TodoItem(
    val id: Int,
    val title: String,
    val description: String,
    val isCompleted: Boolean
)