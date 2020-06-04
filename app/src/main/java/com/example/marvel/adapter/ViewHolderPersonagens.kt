package com.example.marvel.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.marvel.R

class ViewHolderPersonagem(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var imageView: ImageView = itemView.findViewById(R.id.imageCharacters)
    var heroi: TextView = itemView.findViewById(R.id.text_characters)
    var cardViewCharacters: CardView = itemView.findViewById(R.id.card_view_characters)
}