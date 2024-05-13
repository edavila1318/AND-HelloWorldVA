package com.example.a002loginexample.Cards

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.a002loginexample.databinding.CardItemBinding

class cardsAdapter(private val cards:List<cardResponse>):RecyclerView.Adapter<cardViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): cardViewHolder {
        val binding = CardItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return  cardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: cardViewHolder, position: Int) {
        val card = cards[position]
        holder.bind(card)
    }

    override fun getItemCount()=cards.size
}