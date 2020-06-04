package com.example.marvel.adapter

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.marvel.R
import com.example.marvel.model.quadrinhos.Quadrinhos
import com.example.marvel.view.DetailQuadrinhos
import com.squareup.picasso.Picasso

class AdapterQuadrinhos(private val quadrinhosList: MutableSet<Quadrinhos>) : RecyclerView.Adapter<ViewHolderQuadrinhos>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): ViewHolderQuadrinhos {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.comics_iten, viewGroup, false)
        return ViewHolderQuadrinhos(view)
    }

    override fun onBindViewHolder(viewHolderQuadrinhos: ViewHolderQuadrinhos, position: Int) {
        val quadrinho = quadrinhosList.elementAt(position)
        viewHolderQuadrinhos.titulo.text = quadrinho.title
        viewHolderQuadrinhos.edicao.text = quadrinho.issueNumber.toString()
        viewHolderQuadrinhos.ano.text = quadrinho.pageCount.toString()
        Picasso.get().load(quadrinho.thumbnail.path + ".jpg").error(R.drawable.logo_aplicativo)
                .into(viewHolderQuadrinhos.imageView)
        viewHolderQuadrinhos.cardViewComics.setOnClickListener { v ->
            val intent = Intent(v.context, DetailQuadrinhos::class.java)
            val bundle = Bundle()
            bundle.putParcelable("Titulo", quadrinho)
            intent.putExtras(bundle)
            v.context.startActivity(intent)
        }
    }
    override fun getItemCount(): Int {
        return quadrinhosList.size
    }

}