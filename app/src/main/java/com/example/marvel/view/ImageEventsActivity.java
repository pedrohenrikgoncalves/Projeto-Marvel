package com.example.marvel.view;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import com.example.marvel.R;
import com.example.marvel.model.events.ResultsEvents;
import com.squareup.picasso.Picasso;

public class ImageEventsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup_image_events);
        ImageView imageView = findViewById(R.id.image_at_expansion);
        ImageView imageExit = findViewById(R.id.imageExit);

        Window window = getWindow();
        window.setStatusBarColor(getColor(R.color.detailColor));
        getWindow().setNavigationBarColor(ContextCompat.getColor(this, R.color.detailColor));

        if (getIntent().getExtras() != null) {
            ResultsEvents.Data.Events event = getIntent().getExtras().getParcelable("Event");
            Picasso.get().load(event.getThumbnail().getPath() + ".jpg").error(R.drawable.logo_aplicativo).into(imageView);
        }
        imageExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}