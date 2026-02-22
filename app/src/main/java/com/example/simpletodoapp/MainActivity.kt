package com.example.simpletodoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument
import androidx.room.Room.databaseBuilder
import com.example.simpletodoapp.data.TodoDatabase
import com.example.simpletodoapp.ui.HomeScreen
import com.example.simpletodoapp.ui.theme.TaskEntryScreen
import com.example.simpletodoapp.viewmodel.TodoViewModel
import kotlin.jvm.java

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Simple Database Initialization
        val db = databaseBuilder(applicationContext, TodoDatabase::class.java, "todo-db").build()
        val viewModel = TodoViewModel(db.dao)

        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "home") {
                composable("home") {
                    HomeScreen(
                        viewModel = viewModel,
                        onNavigateToAdd = { navController.navigate("task_entry") },
                        onNavigateToEdit = { id -> navController.navigate("task_entry?taskId=$id") }
                    )
                }
                composable(
                    route = "task_entry?taskId={taskId}",
                    arguments = listOf(navArgument("taskId") {
                        type = NavType.StringType; nullable = true; defaultValue = null
                    })
                ) { entry ->
                    val taskId = entry.arguments?.getString("taskId")?.toIntOrNull()
                    TaskEntryScreen(
                        viewModel = viewModel,
                        taskId = taskId,
                        onPopBackStack = { navController.popBackStack() }
                    )
                }
            }
        }
    }
}