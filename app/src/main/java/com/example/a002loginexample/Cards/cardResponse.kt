package com.example.a002loginexample.Cards

import com.google.gson.annotations.SerializedName

class cardResponse {


        @SerializedName("user_id")
        val userId: String? = null
        @SerializedName("card_id")
        val cardId: String? = null
        @SerializedName("card_number")
        val cardNumber: String? = null
        @SerializedName("card_name")
        val cardName: String? = null
        @SerializedName("card_expiration_date")
        val cardExpirationDate: String? = null
        @SerializedName("card_cvv")
        val cardCvv: String? = null
        @SerializedName("card_image_url")
        val cardImageUrl: String? = null

}