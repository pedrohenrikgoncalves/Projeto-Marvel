package com.example.marvel.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProviders
import com.example.marvel.R
import com.example.marvel.model.characters.CharacterRoom
import com.example.marvel.model.characters.ResultsCharacters
import com.example.marvel.model.characters.ResultsCharacters.Data.Characters
import com.example.marvel.viewmodel.ViewModelMarvel
import com.example.marvel.viewmodel.ViewModelRoom
import com.squareup.picasso.Picasso

class DetailCharacters : AppCompatActivity() {

    private lateinit var imageCharacter: ImageView
    private lateinit var imageBackground: ImageView
    private lateinit var title: TextView
    private lateinit var descripiton: TextView
    private lateinit var favorite: Button
    private lateinit var character: Characters
    private val activity = this
    private val viewModelRoom : ViewModelRoom by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.characters_detail)

        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = getColor(R.color.detailColor)
        window.navigationBarColor = ContextCompat.getColor(this, R.color.detailColor)

        imageCharacter = findViewById(R.id.img_characters)
        imageBackground = findViewById(R.id.img_characters_two)
        title = findViewById(R.id.title_characters)
        descripiton = findViewById(R.id.description_characters)
        favorite = findViewById(R.id.btn_character)

        if (intent != null) {
            character = intent.extras?.getParcelable("Hero") ?: Characters()
            if (character.description.isNullOrEmpty()) {
                descripiton.setText(R.string.descri_off)
            } else {
                descripiton.text = character.description
            }
            title.text = character.name
            Picasso.get().load(character.thumbnail!!.path + ".jpg").error(R.drawable.logo_aplicativo).into(imageBackground)
            Picasso.get().load(character.thumbnail!!.path + ".jpg").error(R.drawable.logo_aplicativo).into(imageCharacter)
        } else {
            Toast.makeText(this, R.string.problem_server, Toast.LENGTH_LONG).show()
        }
        imageCharacter.setOnClickListener {
            val bundle = Bundle()
            bundle.putParcelable("Hero", character)
            startActivity(Intent(this, ImageCharactersActivity::class.java).putExtras(bundle))
        }

        favorite.setOnClickListener {
            val characterRoom = CharacterRoom(character.description, character.id, character.name, character.thumbnail?.path + ".jpg")
            viewModelRoom.insertCharacterRoom(activity, characterRoom)
            Toast.makeText(activity, "Add aos favoritos", Toast.LENGTH_LONG).show()
        }
    }
}