package com.example.marvel.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.marvel.R;
import com.example.marvel.model.comics.ResultsComics;
import com.example.marvel.model.events.ResultsEvents;
import com.squareup.picasso.Picasso;

public class DetailEvents extends AppCompatActivity {

    private ImageView imageEvents, imageBackground;
    private TextView title, descripiton;
    ResultsComics.Data.Comics event;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.events_detail);

        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(getColor(R.color.detailColor));
        getWindow().setNavigationBarColor(ContextCompat.getColor(this, R.color.detailColor));

        imageEvents = findViewById(R.id.img_events);
        imageBackground = findViewById(R.id.img_events_two);
        title = findViewById(R.id.title_events);
        descripiton = findViewById(R.id.description_events);

        if (getIntent() != null) {
            ResultsEvents.Data.Events events = getIntent().getExtras().getParcelable("Event");
            if (events.getDescription().isEmpty()) {
                descripiton.setText(R.string.descri_off);
            } else {
                descripiton.setText(events.getDescription());
            }
            title.setText(events.getTitle());
            Picasso.get().load(events.getThumbnail().getPath() + ".jpg").error(R.drawable.logo_aplicativo).into(imageBackground);
            Picasso.get().load(events.getThumbnail().getPath() + ".jpg").error(R.drawable.logo_aplicativo).into(imageEvents);
        }else {
            Toast.makeText(this, R.string.problem_server, Toast.LENGTH_LONG).show();
        }
        imageEvents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ImageEventsActivity.class);
                Bundle bundle = new Bundle();
                bundle.putParcelable("event", event);
                startActivity(intent.putExtras(bundle));
            }
        });
    }
}