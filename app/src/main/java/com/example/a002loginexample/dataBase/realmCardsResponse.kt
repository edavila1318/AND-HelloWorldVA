package com.example.a002loginexample.dataBase

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

open class RealmCardsResponse(): RealmObject {
    var userID: String =""
    @PrimaryKey
    var cardID: String = ""
    var cardNumber: String =""
    var cardName: String = ""
    var cardExpirationDate:String = ""
    var cardCVV: String = ""
    var cardImageURL: String = ""

}