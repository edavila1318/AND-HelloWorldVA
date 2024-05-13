package com.example.a002loginexample.API

import com.google.gson.annotations.SerializedName

class LoginResponse {
    @SerializedName("userID")
    var userID: String? = null
    @SerializedName("imageurl")
    var Imagen: String?=null
    @SerializedName("address")
    var Adress: String?=null
    @SerializedName("name")
    var Name: String?=null
}

