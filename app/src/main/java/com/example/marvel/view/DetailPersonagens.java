package com.example.marvel.view;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.marvel.R;
import com.example.marvel.model.personagens.Personagens;
import com.squareup.picasso.Picasso;

public class DetailPersonagens extends AppCompatActivity {

    private ImageView imageCharacter, imageBackground;
    private TextView title, descripiton;
    private Button favorite;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personagens_detail);

        imageCharacter = findViewById(R.id.img_characters);
        imageBackground = findViewById(R.id. img_characters_two);
        title = findViewById(R.id.title_characters);
        descripiton = findViewById(R.id.description_characters);
        favorite = findViewById(R.id.btn_character);

        if(getIntent() != null){
            Personagens personagem = getIntent().getExtras().getParcelable("Heroi");
            if(personagem.getDescription().isEmpty()) {
                descripiton.setText(R.string.descri_off);
            } else {
                descripiton.setText(personagem.getDescription());
            }
            title.setText(personagem.getName());
            Picasso.get().load(personagem.getThumbnail().getPath() + ".jpg").error(R.drawable.logo_aplicativo).into(imageBackground);
            Picasso.get().load(personagem.getThumbnail().getPath() + ".jpg").error(R.drawable.logo_aplicativo).into(imageCharacter);
        }
    }
}
