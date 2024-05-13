package com.example.a002loginexample

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.a002loginexample.Cards.cardApi
import com.example.a002loginexample.databinding.ActivityWelcomeBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

import java.net.URL
import java.util.concurrent.Executors


class WelcomeActivity : AppCompatActivity() {


    private lateinit var binding: ActivityWelcomeBinding;
    //botton nava bar
    lateinit var bottomNav : BottomNavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //get params
        val nombre = intent.getStringExtra("NOMBRE")
        val direccion = intent.getStringExtra("DIRECCION")
        val imageURL = intent.getStringExtra("IMAGEN")
        val userID = intent.getStringExtra("userID")
        println("userID: "+userID)
        //put params
        var bundle=Bundle();
        bundle.putString("NOMBRE",nombre)
        bundle.putString("DIRECCION",direccion)
        bundle.putString("IMAGEN",imageURL)
        bundle.putString("userID",userID.toString())
        var fragmentAccout = FragmentAccout();
        var fragmentCards = FragmentCards();
        //params
        fragmentAccout.arguments=bundle
        fragmentCards.arguments=bundle

        //tabs y bottom nav bar
        val idFrameLayout = binding.frameLayout.id
        loadFragment(idFrameLayout,fragmentAccout)
        bottomNav=binding.bottonNav;
        bottomNav.setOnItemSelectedListener {
            when (it.itemId){
                R.id.bottom_home -> {
                    loadFragment(idFrameLayout,fragmentAccout)
                    true
                }
                R.id.bottom_cards -> {
                    loadFragment(idFrameLayout,fragmentCards)
                    true
                }

                else -> { false}
            }
        }




    }

    private  fun loadFragment(id: Int, fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(id,fragment)
        transaction.addToBackStack(null)
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
        transaction.commit()
    }

}