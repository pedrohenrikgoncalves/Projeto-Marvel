package com.example.marvel.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import com.example.marvel.R;
import com.example.marvel.model.comics.ResultsComics;
import com.squareup.picasso.Picasso;

public class ImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup_image);
        ImageView imageView = findViewById(R.id.image_at_expansion);
        ImageView imageExit = findViewById(R.id.imageExit);

        Window window = getWindow();
        window.setStatusBarColor(getColor(R.color.detailColor));
        getWindow().setNavigationBarColor(ContextCompat.getColor(this, R.color.detailColor));

        if (getIntent().getExtras() != null) {
            ResultsComics.Data.Comics comic = getIntent().getExtras().getParcelable("comic");
            Picasso.get().load(comic.getThumbnail().getPath() + ".jpg").error(R.drawable.logo_aplicativo).into(imageView);
        }
        imageExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}