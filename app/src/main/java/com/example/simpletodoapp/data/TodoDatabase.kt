package com.example.simpletodoapp.data

import com.example.simpletodoapp.model.TodoTask // <--- L'import doit être présent
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [TodoTask::class], version = 1)
abstract class TodoDatabase : RoomDatabase() {
    abstract val dao: TodoDao
}