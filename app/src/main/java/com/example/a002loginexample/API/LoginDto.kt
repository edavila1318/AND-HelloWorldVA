package com.example.a002loginexample.API

import com.google.gson.annotations.SerializedName

data class LoginDto(
    @SerializedName("User") val User: String,
    @SerializedName("Password") val Password: String
)
