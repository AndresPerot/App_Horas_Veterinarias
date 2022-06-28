package com.example.apphorasveterinarias.lib

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.apphorasveterinarias.Models.DateEntity
import com.example.apphorasveterinarias.Models.UserEntity
import com.example.apphorasveterinarias.dao.DateDAO
import com.example.apphorasveterinarias.dao.UserDAO
import com.example.apphorasveterinarias.utils.Converters


@Database(entities = [UserEntity::class, DateEntity::class], exportSchema = false, version = 7)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDAO
    abstract fun dateDAO(): DateDAO

    companion object{
        const val DATABASE_NAME = "app-horas-veterinarias"
    }

}


