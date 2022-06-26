package com.example.apphorasveterinarias.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.apphorasveterinarias.Models.UserEntity

@Dao
interface UserDAO {
    @Query("SELECT * FROM users WHERE email = :email LIMIT 1")
    fun findByEmail(email: String): UserEntity?

    @Insert
    fun insertUser (user: UserEntity)
}