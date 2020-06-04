package com.example.marvel.adapter

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.marvel.R
import com.example.marvel.model.quadrinhos.Quadrinhos
import com.example.marvel.view.DetailQuadrinhos

class AdapterQuadrinhos(private val quadrinhosList: List<Quadrinhos>) : RecyclerView.Adapter<ViewHolderQuadrinhos>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): ViewHolderQuadrinhos {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.comics_iten, viewGroup, false)
        return ViewHolderQuadrinhos(view)
    }

    override fun onBindViewHolder(viewHolderQuadrinhos: ViewHolderQuadrinhos, position: Int) {
        val quadrinhos = quadrinhosList[position]
        viewHolderQuadrinhos.titulo.text = quadrinhos.titulo
        viewHolderQuadrinhos.edicao.text = quadrinhos.edicao
        viewHolderQuadrinhos.ano.text = quadrinhos.ano
        viewHolderQuadrinhos.imageView.setImageResource(quadrinhos.image)
        viewHolderQuadrinhos.cardViewComics.setOnClickListener { v ->
            val intent = Intent(v.context, DetailQuadrinhos::class.java)
            val bundle = Bundle()
            bundle.putParcelable("Titulo", quadrinhos)
            intent.putExtras(bundle)
            v.context.startActivity(intent)
        }
    }
    override fun getItemCount(): Int {
        return quadrinhosList.size
    }

}