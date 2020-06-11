package com.example.marvel.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.marvel.R;
import com.example.marvel.model.characters.Characters;
import com.squareup.picasso.Picasso;

public class DetailEvents extends AppCompatActivity {

    private ImageView imageEvents, imageBackground;
    private TextView title, descripiton;
    private Button favorite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.events_detail);

        imageEvents = findViewById(R.id.img_events);
        imageBackground = findViewById(R.id.img_events_two);
        title = findViewById(R.id.title_events);
        descripiton = findViewById(R.id.description_events);
        favorite = findViewById(R.id.btn_events);

        if (getIntent() != null) {
            Characters events = getIntent().getExtras().getParcelable("event");
            if (events.getDescription().isEmpty()) {
                descripiton.setText(R.string.descri_off);
            } else {
                descripiton.setText(events.getDescription());
            }
            title.setText(events.getName());
            Picasso.get().load(events.getThumbnail().getPath() + ".jpg").error(R.drawable.logo_aplicativo).into(imageBackground);
            Picasso.get().load(events.getThumbnail().getPath() + ".jpg").error(R.drawable.logo_aplicativo).into(imageEvents);
        }
    }
}