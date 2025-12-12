package com.example.kotlin_module3_7_8

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.kotlin_module3_7_8.navigation.AppNavHost
import com.example.kotlin_module3_7_8.presentation.viewmodel.TodoViewModelFactory
import com.example.kotlin_module3_7_8.ui.theme.Kotlin_module3_78Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppNavHost(factory = TodoViewModelFactory(this))
        }
    }
}
