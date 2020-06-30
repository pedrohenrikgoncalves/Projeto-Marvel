package com.example.marvel.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import com.example.marvel.R;
import com.example.marvel.model.comics.ResultsComics;
import com.squareup.picasso.Picasso;

public class DetailComics extends AppCompatActivity {

    private ImageView imageComics, imageBackgro;
    private TextView title, description;
    private Bundle bundle;
    ResultsComics.Data.Comics comic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comics_detail);

        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(getColor(R.color.detailColor));
        getWindow().setNavigationBarColor(ContextCompat.getColor(this, R.color.detailColor));

        imageComics = findViewById(R.id.img_comics);
        imageBackgro = findViewById(R.id. img_comics_two);
        title = findViewById(R.id.title_comics);
        description = findViewById(R.id.description_comics);

        if(getIntent() != null){
            comic = getIntent().getParcelableExtra("Title");
            if(comic.getDescription() == null || comic.getDescription().isEmpty()) {
                description.setText(R.string.descri_off);
            } else {
                description.setText(comic.getDescription());
            }
            title.setText(comic.getTitle());
            Picasso.get().load(comic.getThumbnail().getPath() + ".jpg").error(R.drawable.logo_aplicativo).into(imageBackgro);
            Picasso.get().load(comic.getThumbnail().getPath() + ".jpg").error(R.drawable.logo_aplicativo).into(imageComics);
        } else {
            Toast.makeText(this, R.string.problem_server, Toast.LENGTH_LONG).show();
        }
        imageComics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ImageComicsActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("comic", comic);
                startActivity(intent.putExtras(bundle));
            }
        });
    }
}
