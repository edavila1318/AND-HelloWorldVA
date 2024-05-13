package com.example.a002loginexample.Cards

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface CardService {

    @POST("accesos_dev/api/cards/")
    fun getCard(@Header("x-api-key") apiKey: String, @Body userID: cardDto): Call<List<cardResponse>>
}