package com.example.marvel.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.marvel.R
import com.example.marvel.adapter.AdapterPersonagens
import com.example.marvel.model.personagens.Personagem
import com.example.marvel.viewmodel.ViewModelMarvel


class PersonagensActivity : AppCompatActivity() {

    private var results = mutableSetOf<Personagem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personagens)
        val recycler = findViewById<RecyclerView>(R.id.recycler_personagens)
        val viewModelCharacter =  ViewModelProviders.of(this).get(ViewModelMarvel::class.java)
        val adapterCharacter = AdapterPersonagens(results)
        recycler.adapter = adapterCharacter
        val layoutManager = LinearLayoutManager(this)
        recycler.layoutManager = layoutManager

        viewModelCharacter.getAllCharacters()
        viewModelCharacter.listCharacter.observe(this, androidx.lifecycle.Observer {
            it?.let { itChar -> results.addAll(itChar) }
            adapterCharacter.notifyDataSetChanged()
        })
    }
}