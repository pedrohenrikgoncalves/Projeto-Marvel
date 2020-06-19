package com.example.marvel.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.Window;

import com.example.marvel.R;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        Window window = getWindow();
        window.setStatusBarColor(getColor(R.color.colorSplash));
        getWindow().setNavigationBarColor(ContextCompat.getColor(this, R.color.colorSplash));
    }
}