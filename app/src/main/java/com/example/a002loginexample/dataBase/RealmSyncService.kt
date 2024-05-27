package com.example.a002loginexample.dataBase

import com.example.a002loginexample.Cards.cardResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class RealmSyncService {
    private val realmCardsDAO: realmCardsDAO = realmCardsDAO()
    private val job = SupervisorJob()
    private val realmScope = CoroutineScope(Dispatchers.IO+job)

    fun doSync (cardsResponse: List<cardResponse>){
        realmScope.launch {
            realmCardsDAO.upsertReealmCards(cardsResponse)
                .catch { e ->
                    e.printStackTrace()
                }
                .collect{success ->
                    realmScope.launch {
                        realmCardsDAO.getCards()
                            .catch { e ->
                                e.printStackTrace()
                            }
                            .collect{ result ->
                                var a = result
                                var b = 3
                            }
                    }
                }
        }
    }
}