package com.example.a002loginexample.API
import android.content.Context
import android.content.Intent
import androidx.core.content.ContextCompat.startActivity
import com.example.a002loginexample.WelcomeActivity
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import okhttp3.internal.wait

class AppAPI {

    var BaseURL="https://www.balam-knights.com/"
    var AppID="2e65127e909e178d0af311a81f39948c"
    var ApiKey="81818BBF-C772-411D-9BFA-3CAFA12D6077"


    fun validateUser(context: Context,username: String, password: String): String? {

        /*return if (password == "admin" && username == "admin"){
            UUID.randomUUID().toString()
        } else {
            null

        }
        */
        var res: String? = null;
        val retrofit=Retrofit.Builder()
            .baseUrl(this.BaseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service=retrofit.create(LoginService::class.java)

        val call=service.validateCredentials(LoginDto(User = username,
            Password = password))


        call.enqueue(object : retrofit2.Callback<LoginResponse>{
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                println("login: "+response.body().toString())
                var nombre=""
                var direccion=""
                var imagen=""
                var userID=""
                if (response.code() == 200) {
                    nombre= response.body()?.Name.toString()
                    direccion=response.body()?.Adress.toString()
                    imagen=response.body()?.Imagen.toString()
                    userID= response.body()?.userID.toString();

                    val intent = Intent(context, WelcomeActivity::class.java).apply {
                        putExtra("NOMBRE", nombre)
                        putExtra("DIRECCION",direccion)
                        putExtra("IMAGEN",imagen)
                        putExtra("userID",userID)
                    }
                    startActivity(context,intent,null)
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                println(t.message)
                res=null;
            }
        })


        return res;
    }


}