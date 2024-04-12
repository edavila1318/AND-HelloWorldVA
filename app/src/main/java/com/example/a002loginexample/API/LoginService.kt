package com.example.a002loginexample.API

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query

interface LoginService {
    @Headers("x-api-key: 81818BBF-C772-411D-9BFA-3CAFA12D6077")
    @POST("accesos_dev/api/Auth/")
    fun validateCredentials(@Body LoginDto: LoginDto): Call<LoginResponse>

    //fun validateCredentials(@Query("User") User: String, @Query("Password") Password: String): Call<LoginResponse>

}