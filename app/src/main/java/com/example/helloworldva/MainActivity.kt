package com.example.helloworldva

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
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
        binding.txtHelloWorld.text = "hola mundo BI";
        setContentView(view);

        binding.btnHelloWorld.setOnClickListener{
            this.binding.txtHelloWorld.text = this.binding.inpHelloWorld.text;
        }

    }


}