package com.example.marvel.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.marvel.R;
import com.example.marvel.model.creators.ResultsCreators;
import com.squareup.picasso.Picasso;

public class DetailCreators extends AppCompatActivity {

    private ImageView imageCreators, imageBackground;
    private TextView title, descripiton;
    private Button favorite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.creators_detail);

        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(getColor(R.color.detailColor));
        getWindow().setNavigationBarColor(ContextCompat.getColor(this, R.color.detailColor));

        imageCreators = findViewById(R.id.img_creators);
        imageBackground = findViewById(R.id.img_creators_two);
        title = findViewById(R.id.title_creators);
        descripiton = findViewById(R.id.description_creators);

        if (getIntent() != null) {
            ResultsCreators.Data.Creators creators = getIntent().getExtras().getParcelable("Creator");
            if (creators.getResourceURI().isEmpty()) {
                descripiton.setText(R.string.descri_off);
            } else {
                descripiton.setText(creators.getResourceURI());
            }
            title.setText(creators.getFullName());
            Picasso.get().load(creators.getThumbnail().getPath() + ".jpg").error(R.drawable.logo_aplicativo).into(imageBackground);
            Picasso.get().load(creators.getThumbnail().getPath() + ".jpg").error(R.drawable.logo_aplicativo).into(imageCreators);
        }else {
            Toast.makeText(this, R.string.problem_server, Toast.LENGTH_LONG).show();
        }
    }
}