package com.example.marvel.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.marvel.R
import com.example.marvel.adapter.AdapterQuadrinhos
import com.example.marvel.model.Quadrinhos
import java.util.*

class QuadrinhosActivity : AppCompatActivity() {
    private var recyclerView: RecyclerView? = null
    private var adapterQuadrinhos: AdapterQuadrinhos? = null
    private val quadrinhosList: List<Quadrinhos> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quadrinhos)
        recyclerView = findViewById(R.id.recycler_quadrinhos)
        adapterQuadrinhos = AdapterQuadrinhos(listaDeQuadrinhos())
        //Dando erro nas duas linhas abaixo
        layoutManager = LinearLayoutManager(activity)
        adapter = ListAdapter(mNicolasCageMovies)
        //recyclerView.setLayoutManager(LinearLayoutManager(this))
        //recyclerView.setAdapter(adapterQuadrinhos)
    }

    private fun listaDeQuadrinhos(): List<Quadrinhos> {
        val quadrinhos: MutableList<Quadrinhos> = ArrayList()
        val imageResource = R.drawable.marvel_login
        quadrinhos.add(Quadrinhos(imageResource, "Venom", "nº 12", "2020"))
        quadrinhos.add(Quadrinhos(imageResource, "X-Men A Queda", "Vol 01", "2011"))
        quadrinhos.add(Quadrinhos(imageResource, "Thor", "nº 02", "2015"))
        quadrinhos.add(Quadrinhos(imageResource, "Homem Aranha", "nº 141", "2017"))
        quadrinhos.add(Quadrinhos(imageResource, "Hulk", "Vol 03", "2010"))
        quadrinhos.add(Quadrinhos(imageResource, "Deadpool", "nº 15", "2006"))
        quadrinhos.add(Quadrinhos(imageResource, "Guardiões da Galáxia", "nº 01", "2011"))
        return quadrinhos
    }
}