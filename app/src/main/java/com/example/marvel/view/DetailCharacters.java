package com.example.marvel.view;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.marvel.R;
import com.example.marvel.model.characters.Characters;
import com.squareup.picasso.Picasso;

public class DetailCharacters extends AppCompatActivity {

    private ImageView imageCharacter, imageBackground;
    private TextView title, descripiton;
    private Button favorite;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.characters_detail);

        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(getColor(R.color.colorSplash));

        imageCharacter = findViewById(R.id.img_characters);
        imageBackground = findViewById(R.id. img_characters_two);
        title = findViewById(R.id.title_characters);
        descripiton = findViewById(R.id.description_characters);
        favorite = findViewById(R.id.btn_character);

        if(getIntent() != null){
            Characters characters = getIntent().getExtras().getParcelable("Hero");
            if(characters.getDescription().isEmpty()) {
                descripiton.setText(R.string.descri_off);
            } else {
                descripiton.setText(characters.getDescription());
            }
            title.setText(characters.getName());
            Picasso.get().load(characters.getThumbnail().getPath() + ".jpg").error(R.drawable.logo_aplicativo).into(imageBackground);
            Picasso.get().load(characters.getThumbnail().getPath() + ".jpg").error(R.drawable.logo_aplicativo).into(imageCharacter);
        }
    }
}
