package com.example.a002loginexample

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.a002loginexample.API.AppAPI
import com.example.a002loginexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginButton.setOnClickListener {
            val username = binding.usernameEditText.text.toString().trim()
            val password = binding.passwordEditText.text.toString().trim()

            validateLogin(username, password)
        }
    }

    private fun validateLogin(username: String, password: String) {
        showToast("hola")
        println("hola 2")
        val sessionToken = AppAPI().validateUser(this,username, password)
        println(sessionToken)
        if (sessionToken != null) {
            val intent = Intent(this, WelcomeActivity::class.java).apply {
                putExtra("SESSION_TOKEN", sessionToken)
            }
            startActivity(intent)
        } else {
            showToast("Invalid username or password")
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}