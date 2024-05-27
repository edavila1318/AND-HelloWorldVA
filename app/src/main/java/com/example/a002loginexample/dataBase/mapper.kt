package com.example.a002loginexample.dataBase

import com.example.a002loginexample.Cards.cardResponse


fun RealmCardsResponse.toCardsResponse() = cardResponse(
    userId = userID,
    cardId = cardID,
    cardNumber = cardNumber,
    cardName = cardName,
    cardExpirationDate = cardExpirationDate,
    cardCvv = cardCVV,
    cardImageUrl = cardImageURL


)

