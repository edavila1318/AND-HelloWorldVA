package com.example.a002loginexample.dataBase

import com.example.a002loginexample.Cards.cardResponse
import io.realm.kotlin.Realm
import io.realm.kotlin.UpdatePolicy
import io.realm.kotlin.ext.query
import io.realm.kotlin.ext.toRealmList
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



                    cardsResponse.map {cardItem ->
                        copyToRealm(
                        RealmCardsResponse().apply {
                        userID = cardItem.userId.toString()
                        cardID = cardItem.cardId.toString()
                        cardNumber = cardItem.cardNumber.toString()
                        cardName = cardItem.cardName.toString()
                        cardExpirationDate = cardItem.cardExpirationDate.toString()
                        cardCVV = cardItem.cardCvv.toString()
                        cardImageURL = cardItem.cardImageUrl.toString()

                    }, updatePolicy = UpdatePolicy.ALL)

                }

            }
            realm.close()
            emit(true)
        }

    }

    fun getCards(): Flow<List<cardResponse?>>{
        return  flow {
            val realm= Realm.open(config)
            var result: List<cardResponse> = listOfNotNull()
            realm.write {
                val realCardsResponse = realm.query<RealmCardsResponse>().find()
                val realmCard = realm.copyFromRealm(realCardsResponse)
                result = realmCard.map { card ->
                    card.toCardsResponse()
                }
            }
            realm.close()
            emit(result)
        }.flowOn(Dispatchers.IO)
    }
}