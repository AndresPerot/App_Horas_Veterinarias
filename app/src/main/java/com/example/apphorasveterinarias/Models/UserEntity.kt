package com.example.apphorasveterinarias.Models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "users", indices = [Index(value = ["email"], unique = true)] )
 data class UserEntity (
    @PrimaryKey (autoGenerate = true) val id: Long?,
    @ColumnInfo(name = "first_name") val name: String,
    @ColumnInfo(name = "last_name") val lastname: String,
    @ColumnInfo(name = "email") val email: String,
    @ColumnInfo(name = "password")val password: String
         )






