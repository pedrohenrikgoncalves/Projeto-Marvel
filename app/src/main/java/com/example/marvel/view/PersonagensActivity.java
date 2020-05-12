package com.example.marvel.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.marvel.adapter.AdapterPersonagens;
import com.example.marvel.model.Personagens;
import com.example.marvel.R;

import java.util.ArrayList;
import java.util.List;

public class PersonagensActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AdapterPersonagens adapterPersonagens;
    private List<Personagens> alunoList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personagens);

        recyclerView = findViewById(R.id.recycler_main);
        adapterPersonagens = new AdapterPersonagens(listaDePersonagens());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapterPersonagens);

    }

    private List<Personagens> listaDePersonagens(){
        List<Personagens> personagens = new ArrayList<>();

        int imageResource = R.drawable.marvel_login;

        personagens.add(new Personagens(imageResource,"Iron-Man", "Tony Stark"));
        personagens.add(new Personagens(imageResource,"Captain America","Steve Rogers"));
        personagens.add(new Personagens(imageResource,"Thor", "Thor Odinson"));
        personagens.add(new Personagens(imageResource,"Spider-Man","Peter Parker"));
        personagens.add(new Personagens(imageResource,"Hulk", "Robert Bruce Banner"));
        personagens.add(new Personagens(imageResource,"Doutor Stranger", "Stephen Vincent Strange"));
        personagens.add(new Personagens(imageResource,"Black Widow", "Natalia Alianovna Romanoff"));

        return personagens;
    }

}
