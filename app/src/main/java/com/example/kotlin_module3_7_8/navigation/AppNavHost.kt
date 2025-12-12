package com.example.kotlin_module3_7_8.navigation


import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kotlin_module3_7_8.presentation.ui.screen.TodoDetailScreen
import com.example.kotlin_module3_7_8.presentation.ui.screen.TodoListScreen
import com.example.kotlin_module3_7_8.presentation.viewmodel.TodoViewModel
import com.example.kotlin_module3_7_8.presentation.viewmodel.TodoViewModelFactory

@Composable
fun AppNavHost(factory: TodoViewModelFactory) {
    val navController = rememberNavController()
    val vm: TodoViewModel = viewModel(factory = factory)

    LaunchedEffect(Unit) { vm.load() }

    NavHost(navController = navController, startDestination = Routes.LIST) {
        composable(Routes.LIST) {
            TodoListScreen(
                vm = vm,
                onOpenDetails = { id -> navController.navigate(Routes.details(id)) }
            )
        }
        composable(Routes.DETAILS) { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id")?.toIntOrNull() ?: -1
            TodoDetailScreen(id = id, vm = vm)
        }
    }
}