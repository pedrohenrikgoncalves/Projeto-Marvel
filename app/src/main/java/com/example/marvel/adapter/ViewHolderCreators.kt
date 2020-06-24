package com.example.marvel.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.marvel.R

class ViewHolderCreators (itemView: View) : RecyclerView.ViewHolder(itemView){

    var creators: TextView = itemView.findViewById(R.id.text_creators)
    var cardViewCreators: CardView = itemView.findViewById(R.id.card_view_creators)
}