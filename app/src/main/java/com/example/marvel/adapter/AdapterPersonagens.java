package com.example.marvel.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.marvel.model.Personagens;
import com.example.marvel.R;

import java.util.List;

public class AdapterPersonagens extends RecyclerView.Adapter<ViewHolderPersonagens> {

    private List<Personagens> personagensList;

    public AdapterPersonagens(List<Personagens> personagensList) {
        this.personagensList = personagensList;
    }

    @NonNull
    @Override
    public ViewHolderPersonagens onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.characters_iten, viewGroup, false);
        return new ViewHolderPersonagens(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolderPersonagens viewHolderPersonagens, int position) {

        Personagens personagens = personagensList.get(position);
        viewHolderPersonagens.heroi.setText(personagens.getHeroi());
        viewHolderPersonagens.nome.setText(personagens.getNome());
        viewHolderPersonagens.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

        }
    });
}


    @Override
    public int getItemCount() {
        return personagensList.size();
    }
}