package com.example.a002loginexample.Cards

import com.google.gson.annotations.SerializedName

class cardResponse (


        @SerializedName("user_id")
        val userId: String,
        @SerializedName("card_id")
        val cardId: String,
        @SerializedName("card_number")
        val cardNumber: String,
        @SerializedName("card_name")
        val cardName: String,
        @SerializedName("card_expiration_date")
        val cardExpirationDate: String,
        @SerializedName("card_cvv")
        val cardCvv: String,
        @SerializedName("card_image_url")
        val cardImageUrl: String,

)