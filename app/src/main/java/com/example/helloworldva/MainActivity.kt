package com.example.helloworldva

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.example.helloworldva.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       // val textViewHelloWorld = findViewById<TextView>(R.id.txtHelloWorld);
        //textViewHelloWorld.text = "Banco industrial";

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view);

        val onClickListener = binding.btnLogin.setOnClickListener {

            var user = binding.inpUser.text.toString();
            var password = binding.inpPass.text.toString();
            login(user,password);
        }



    }
    private fun login(user:String,password:String){
        var resultado="Usuario o contraseña incorrecta";
        if(user=="admin" && password=="admin")
        {
            resultado="Admin, bienvenido a la aplicacion"
        }
        mostarToast(resultado)

    }


    private fun mostarToast(mensaje:String){
        val duracion = Toast.LENGTH_SHORT
        val toast=Toast.makeText(this,mensaje,duracion)
        toast.show()
    }

}