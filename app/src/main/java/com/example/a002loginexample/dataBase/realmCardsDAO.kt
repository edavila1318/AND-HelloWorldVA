package com.example.a002loginexample.dataBase

import com.example.a002loginexample.Cards.cardResponse
import io.realm.kotlin.Realm
import io.realm.kotlin.UpdatePolicy
import io.realm.kotlin.ext.query
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class realmCardsDAO : BaseDAO() {

    companion object {
        val STORES = listOf(
            RealmCardsResponse::class
        ).toSet()
    }

    fun upsertReealmCards(cardsResponse: List<cardResponse>): Flow<Boolean>{
        return  flow{
            val realm = Realm.open(config)
            realm.write {
                copyToRealm(RealmCardsResponse().apply {
                    cardsResponse.map {cardItem ->
                        userID = cardItem.userId.toString()
                        cardID = cardItem.cardId.toString()
                        cardNumber = cardItem.cardNumber.toString()
                        cardName = cardItem.cardName.toString()
                        cardExpirationDate = cardItem.cardExpirationDate.toString()
                        cardCVV = cardItem.cardCvv.toString()
                        cardImageURL = cardItem.cardImageUrl.toString()

                    }

                }, updatePolicy = UpdatePolicy.ALL)
            }
            realm.close()
            emit(true)
        }

    }

    fun getCards(): Flow<cardResponse?>{
        return  flow {
            val realm= Realm.open(config)
            var result: cardResponse? = null
            realm.write {
                val realCardsResponse = realm.query<RealmCardsResponse>().find()
                val realmCard = realCardsResponse.first()!!
                result = realmCard.toCardsResponse()
            }
            realm.close()
            emit(result)
        }.flowOn(Dispatchers.IO)
    }
}