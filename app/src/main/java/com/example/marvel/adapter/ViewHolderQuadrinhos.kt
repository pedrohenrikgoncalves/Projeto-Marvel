package com.example.marvel.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.marvel.R

class ViewHolderQuadrinhos(itemView: View) : RecyclerView.ViewHolder(itemView){
    var titulo: TextView = itemView.findViewById(R.id.text_titulo)
    var edicao: TextView = itemView.findViewById(R.id.text_edicao)
    var ano: TextView = itemView.findViewById(R.id.text_ano)
    var cardViewComics: CardView = itemView.findViewById(R.id.card_view_comics)
    var imageView: ImageView = itemView.findViewById(R.id.imageComics)
}