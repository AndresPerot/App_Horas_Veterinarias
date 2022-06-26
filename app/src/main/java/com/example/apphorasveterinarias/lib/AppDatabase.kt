package com.example.apphorasveterinarias.lib

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.apphorasveterinarias.Models.DateEntity
import com.example.apphorasveterinarias.Models.UserEntity
import com.example.apphorasveterinarias.dao.DateDAO
import com.example.apphorasveterinarias.dao.UserDAO


@Database(entities = [UserEntity::class, DateEntity::class], version = 4)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDAO
    abstract fun dateDAO(): DateDAO

}

