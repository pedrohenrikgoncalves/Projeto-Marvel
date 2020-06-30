package com.example.marvel.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import com.example.marvel.R;
import com.example.marvel.model.characters.ResultsCharacters;
import com.squareup.picasso.Picasso;

public class ImageCharactersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup_image_characters);
        ImageView imageView = findViewById(R.id.image_at_expansio);
        ImageView imageExit = findViewById(R.id.imageExit);

        Window window = getWindow();
        window.setStatusBarColor(getColor(R.color.detailColor));
        getWindow().setNavigationBarColor(ContextCompat.getColor(this, R.color.detailColor));

        if (getIntent().getExtras() != null) {
            ResultsCharacters.Data.Characters character = getIntent().getExtras().getParcelable("character");
            Picasso.get().load(character.getThumbnail().getPath() + ".jpg").error(R.drawable.logo_aplicativo).into(imageView);
        }
        imageExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}