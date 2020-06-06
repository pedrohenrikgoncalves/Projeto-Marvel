package com.example.marvel.view;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.marvel.R;
import com.example.marvel.model.quadrinhos.Quadrinhos;
import com.squareup.picasso.Picasso;

public class DetailQuadrinhos extends AppCompatActivity {
    private ImageView imageComics, imageBackgro;
    private TextView title, description;
    private Button favorite;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quadrinhos_detail);

        imageComics = findViewById(R.id.img_comics);
        imageBackgro = findViewById(R.id. img_comics_two);
        title = findViewById(R.id.title_comics);
        description = findViewById(R.id.description_comics);
        favorite = findViewById(R.id.btn_comics);

        if(getIntent() != null){
            Quadrinhos quadrinho = getIntent().getExtras().getParcelable("Titulo");
            if(quadrinho.getDescription().isEmpty()) {
                description.setText(R.string.descri_off);
            } else {
                description.setText(quadrinho.getDescription());
            }
            title.setText(quadrinho.getTitle());
            Picasso.get().load(quadrinho.getThumbnail().getPath() + ".jpg").error(R.drawable.logo_aplicativo).into(imageBackgro);
            Picasso.get().load(quadrinho.getThumbnail().getPath() + ".jpg").error(R.drawable.logo_aplicativo).into(imageComics);
        }
    }
}
