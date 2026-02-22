package com.example.simpletodoapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simpletodoapp.data.TodoDao
import com.example.simpletodoapp.model.TodoTask
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class TodoViewModel(private val dao: TodoDao) : ViewModel() {
    val tasks = dao.getAllTasks().stateIn(
        viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList()
    )

    fun onTaskCheckedChange(task: TodoTask, isChecked: Boolean) {
        viewModelScope.launch { dao.upsertTask(task.copy(isCompleted = isChecked)) }
    }

    fun deleteTask(task: TodoTask) {
        viewModelScope.launch { dao.deleteTask(task) }
    }

    suspend fun getTask(id: Int) = dao.getTaskById(id)

    fun saveTask(id: Int? = null, title: String, description: String) {
        viewModelScope.launch {
            val task = id?.let { dao.getTaskById(it)?.copy(title = title, description = description) }
                ?: TodoTask(title = title, description = description)
            dao.upsertTask(task)
        }
    }
}