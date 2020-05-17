package com.example.marvel.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.marvel.R

class ViewHolderQuadrinhos(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var imageView: ImageView
    var titulo: TextView
    var edicao: TextView
    var ano: TextView
    var cardViewComics: CardView

    init {
        titulo = itemView.findViewById(R.id.text_titulo)
        edicao = itemView.findViewById(R.id.text_edicao)
        ano = itemView.findViewById(R.id.text_ano)
        cardViewComics = itemView.findViewById(R.id.card_view_comics)
        imageView = itemView.findViewById(R.id.imagePersonagens)
    }
}