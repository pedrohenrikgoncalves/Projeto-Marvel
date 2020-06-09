package com.example.marvel.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.marvel.R
import com.example.marvel.adapter.AdapterCharacters
import com.example.marvel.model.characters.Characters
import com.example.marvel.viewmodel.ViewModelMarvel


class CharactersActivity : AppCompatActivity() {

    private var results = mutableSetOf<Characters>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_characters)
        val recycler = findViewById<RecyclerView>(R.id.recycler_characters)
        val viewModelCharacter =  ViewModelProviders.of(this).get(ViewModelMarvel::class.java)
        val adapterCharacter = AdapterCharacters(results)
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