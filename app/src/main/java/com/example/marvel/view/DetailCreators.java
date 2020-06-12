package com.example.marvel.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.marvel.R;
import com.example.marvel.model.characters.Characters;
import com.squareup.picasso.Picasso;

public class DetailCreators extends AppCompatActivity {

    private ImageView imageCreators, imageBackground;
    private TextView title, descripiton;
    private Button favorite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.creators_detail);

        imageCreators = findViewById(R.id.img_creators);
        imageBackground = findViewById(R.id.img_creators_two);
        title = findViewById(R.id.title_creators);
        descripiton = findViewById(R.id.description_creators);
        favorite = findViewById(R.id.btn_creators);

        if (getIntent() != null) {
            Characters creators = getIntent().getExtras().getParcelable("Creator");
            if (creators.getDescription().isEmpty()) {
                descripiton.setText(R.string.descri_off);
            } else {
                descripiton.setText(creators.getDescription());
            }
            title.setText(creators.getName());
            Picasso.get().load(creators.getThumbnail().getPath() + ".jpg").error(R.drawable.logo_aplicativo).into(imageBackground);
            Picasso.get().load(creators.getThumbnail().getPath() + ".jpg").error(R.drawable.logo_aplicativo).into(imageCreators);
        }
    }
}