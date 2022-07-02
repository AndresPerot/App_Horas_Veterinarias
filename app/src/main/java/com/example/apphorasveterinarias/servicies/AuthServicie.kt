package com.example.apphorasveterinarias.servicies

import com.example.apphorasveterinarias.Models.LoginPayloadDTO
import com.example.apphorasveterinarias.Models.LoginResponseDTO
import com.example.apphorasveterinarias.Models.RegisterPayloadDTO
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthServicie {

    @POST ("/api/auth/local")
    fun login(@Body payload: LoginPayloadDTO): Call<LoginResponseDTO>

    @POST("/api/auth/local/register")
    fun register(@Body payload: RegisterPayloadDTO): Call<Void>


}