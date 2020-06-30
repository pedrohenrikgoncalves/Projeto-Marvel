package com.example.marvel.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.marvel.R;
import com.example.marvel.model.characters.ResultsCharacters;
import com.example.marvel.model.comics.ResultsComics;
import com.squareup.picasso.Picasso;

public class DetailCharacters extends AppCompatActivity {

    private ImageView imageCharacter;
    private ImageView imageBackground;
    private TextView title, descripiton;
    private Button favorite;
    ResultsCharacters.Data.Characters character;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.characters_detail);

        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(getColor(R.color.detailColor));
        getWindow().setNavigationBarColor(ContextCompat.getColor(this, R.color.detailColor));


        imageCharacter = findViewById(R.id.img_characters);
        imageBackground = findViewById(R.id. img_characters_two);
        title = findViewById(R.id.title_characters);
        descripiton = findViewById(R.id.description_characters);
        favorite = findViewById(R.id.btn_character);

        if(getIntent() != null){
            ResultsCharacters.Data.Characters characters = getIntent().getExtras().getParcelable("Hero");
            if(characters.getDescription().isEmpty()) {
                descripiton.setText(R.string.descri_off);
            } else {
                descripiton.setText(characters.getDescription());
            }
            title.setText(characters.getName());
            Picasso.get().load(characters.getThumbnail().getPath() + ".jpg").error(R.drawable.logo_aplicativo).into(imageBackground);
            Picasso.get().load(characters.getThumbnail().getPath() + ".jpg").error(R.drawable.logo_aplicativo).into(imageCharacter);
        }else {
            Toast.makeText(this, R.string.problem_server, Toast.LENGTH_LONG).show();
        }
        imageCharacter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ImageCharactersActivity.class);
                Bundle bundle = new Bundle();
                bundle.putParcelable("character", character);
                startActivity(intent.putExtras(bundle));
            }
        });
    }
}
