package com.example.marvel.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.marvel.R;

public class HomeActivity extends AppCompatActivity {

    Button personagens;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        personagens = findViewById(R.id.buttonPersonagens);

        personagens.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PersonagensActivity.class);
                startActivity(intent);
            }
        });

    }
}
