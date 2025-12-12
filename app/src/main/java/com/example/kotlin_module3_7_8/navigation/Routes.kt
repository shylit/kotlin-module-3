package com.example.kotlin_module3_7_8.navigation

object Routes {
    const val LIST = "list"
    const val DETAILS = "details/{id}"
    fun details(id: Int) = "details/$id"
}