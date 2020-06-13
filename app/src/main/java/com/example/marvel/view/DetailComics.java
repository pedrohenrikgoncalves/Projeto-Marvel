package com.example.marvel.view;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.example.marvel.R;
import com.example.marvel.model.comics.Comic;
import com.squareup.picasso.Picasso;

public class DetailComics extends AppCompatActivity {
    private ImageView imageComics, imageBackgro;
    private TextView title, description;
    private Button favorite;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comics_detail);

        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(getColor(R.color.topbar));

        imageComics = findViewById(R.id.img_comics);
        imageBackgro = findViewById(R.id. img_comics_two);
        title = findViewById(R.id.title_comics);
        description = findViewById(R.id.description_comics);
        favorite = findViewById(R.id.btn_comics);

        if(getIntent() != null){
            Comic comic = getIntent().getExtras().getParcelable("Title");
            if(comic.getDescription().isEmpty()) {
                description.setText(R.string.descri_off);
            } else {
                description.setText(comic.getDescription());
            }
            title.setText(comic.getTitle());
            Picasso.get().load(comic.getThumbnail().getPath() + ".jpg").error(R.drawable.logo_aplicativo).into(imageBackgro);
            Picasso.get().load(comic.getThumbnail().getPath() + ".jpg").error(R.drawable.logo_aplicativo).into(imageComics);
        } else {
            Toast.makeText(this, "Problemas com servidor", Toast.LENGTH_LONG).show();
        }
    }
}
