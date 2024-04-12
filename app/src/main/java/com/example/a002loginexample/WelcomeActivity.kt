package com.example.a002loginexample

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.a002loginexample.databinding.ActivityWelcomeBinding

import java.net.URL
import java.util.concurrent.Executors


class WelcomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nombre = intent.getStringExtra("NOMBRE")
        val direccion = intent.getStringExtra("DIRECCION")
        val imageURL = intent.getStringExtra("IMAGEN")


        binding.lblNombre.text =  nombre
        binding.lblDireccion.text = direccion
        // Initializing the image
        var image: Bitmap? = null
        val executor = Executors.newSingleThreadExecutor()
        val handler = Handler(Looper.getMainLooper())

        // Only for Background process (can take time depending on the Internet speed)
        executor.execute {



            // Tries to get the image and post it in the ImageView
            // with the help of Handler
            try {
                val `in` = URL(imageURL).openStream()
                image = BitmapFactory.decodeStream(`in`)

                // Only for making changes in UI
                handler.post {
                    binding.imgPerfil.setImageBitmap(image)
                    //imageView.setImageBitmap(image)
                }
            }

            // If the URL doesnot point to
            // image or any other kind of failure
            catch (e: Exception) {
                e.printStackTrace()
            }
        }

    }
}