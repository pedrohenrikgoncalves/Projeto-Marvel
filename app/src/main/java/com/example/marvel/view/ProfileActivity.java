package com.example.marvel.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.marvel.R;
import com.example.marvel.viewmodel.ViewModelLogin;
import com.squareup.picasso.Picasso;

public class ProfileActivity extends AppCompatActivity {

    private ImageView imageView, imageUser;
    private TextView userName;
    private ViewModelLogin viewModelLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Window window = getWindow();
        window.setStatusBarColor(getColor(R.color.colorSplash));
        getWindow().setNavigationBarColor(ContextCompat.getColor(this, R.color.colorSplash));

        imageView = findViewById(R.id.circleImageView);
        userName = findViewById(R.id.username);
        imageUser = findViewById(R.id.image_user);

        viewModelLogin = ViewModelProviders.of(this).get(ViewModelLogin.class);
        Picasso.get().load(viewModelLogin.getUser().getPhotoUrl()).into(imageView);

        userName.setHint(viewModelLogin.getUser().getDisplayName());

    }
}