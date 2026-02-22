package com.example.simpletodoapp.data

import com.example.simpletodoapp.model.TodoTask
import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {
    @Query("SELECT * FROM tasks ORDER BY isCompleted ASC, timestamp DESC")
    fun getAllTasks(): Flow<List<TodoTask>>

    @Query("SELECT * FROM tasks WHERE id = :id")
    suspend fun getTaskById(id: Int): TodoTask?

    @Upsert
    suspend fun upsertTask(task: TodoTask)

    @Delete
    suspend fun deleteTask(task: TodoTask)
}