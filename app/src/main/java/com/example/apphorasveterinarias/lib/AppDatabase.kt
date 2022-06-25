package com.example.apphorasveterinarias.lib

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.apphorasveterinarias.Models.UserEntity
import com.example.apphorasveterinarias.dao.UserDAO

@Database(entities = [UserEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDAO
}