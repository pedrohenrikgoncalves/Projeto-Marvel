package com.example.marvel.view

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
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
        val progressbar = findViewById<ProgressBar>(R.id.progressBar)
        val viewModelCharacter =  ViewModelProviders.of(this).get(ViewModelMarvel::class.java)
        val adapterCharacter = AdapterCharacters(results)
        recycler.adapter = adapterCharacter
        val layoutManager = LinearLayoutManager(this)
        recycler.layoutManager = layoutManager

        viewModelCharacter.getAllCharacters()
        viewModelCharacter.listCharacter.observe(this, androidx.lifecycle.Observer {
            it?.let {
                it.forEach { character ->
                    if (!character.thumbnail.path.contains("image_not_available")) {
                        results.add(character)
                    }
                }
            }
            adapterCharacter.notifyDataSetChanged()
        })
        viewModelCharacter.loading.observe(this, Observer { loading ->
            if (loading) {
                progressbar.visibility = View.VISIBLE
            } else {
                progressbar.visibility = View.GONE
            }
        })
    }
}