package com.example.a002loginexample.Cards

import com.google.gson.annotations.SerializedName

data class cardDto(
    @SerializedName("userID") val userID: Int
)
