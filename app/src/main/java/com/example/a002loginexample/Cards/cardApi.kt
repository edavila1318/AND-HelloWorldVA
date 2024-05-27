package com.example.a002loginexample.Cards

import androidx.recyclerview.widget.RecyclerView
import com.example.a002loginexample.dataBase.RealmSyncService
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class cardApi {

    var baseURL="https://www.balam-knights.com/"
    var apiKey="81818BBF-C772-411D-9BFA-3CAFA12D6077"


    fun getCards(userId:Int, recyclerView: RecyclerView){
        val retrofit = Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(CardService::class.java)
        val call = service.getCard(apiKey, cardDto(userID = userId))

        call.enqueue(object: retrofit2.Callback<List<cardResponse>> {
            override fun onResponse(
                call: Call<List<cardResponse>>,
                response: Response<List<cardResponse>>
            ){
            if(response.code()==200)
            {


                var cardsResponse = response.body()!!

                //database
                val realmSyncService = RealmSyncService()
                realmSyncService.doSync(cardsResponse)

                var adapter = cardsAdapter(cardsResponse)
                recyclerView.adapter = adapter
            }
            else
            {
                println(response.toString())
            }
        }
            override fun onFailure(call: Call<List<cardResponse>>, t: Throwable) {
                println(t.message)
            }
        })
    }
}