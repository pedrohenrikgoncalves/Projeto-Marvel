package com.example.marvel.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.marvel.R

class ViewHolderEvents(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var events: TextView = itemView.findViewById(R.id.text_events)
    var imageView: ImageView = itemView.findViewById(R.id.imageEvents)
    var cardViewEvents: CardView = itemView.findViewById(R.id.card_view_events)
}