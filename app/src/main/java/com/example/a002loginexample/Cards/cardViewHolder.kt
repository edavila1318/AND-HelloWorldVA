package com.example.a002loginexample.Cards

import androidx.recyclerview.widget.RecyclerView
import com.example.a002loginexample.databinding.CardItemBinding
import com.squareup.picasso.Picasso

class cardViewHolder(private val binding: CardItemBinding): RecyclerView.ViewHolder(binding.root){
    fun bind(card: cardResponse){
        binding.cardName.text=card.cardName
        binding.cardExpiration.text = card.cardExpirationDate
        binding.cardCvv.text=card.cardCvv
        Picasso.get().load(card.cardImageUrl).into(binding.cardImage)
    }
}