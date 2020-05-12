package com.example.marvel.adapter;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.marvel.model.Personagens;
import com.example.marvel.R;
import com.example.marvel.view.DetailPersonagens;
import com.example.marvel.view.RegisterActivity;

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

        final Personagens personagens = personagensList.get(position);

        viewHolderPersonagens.heroi.setText(personagens.getHeroi());
        viewHolderPersonagens.nome.setText(personagens.getNome());
        viewHolderPersonagens.imageView.setImageResource(personagens.getImage());
        viewHolderPersonagens.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), DetailPersonagens.class);
                Bundle bundle = new Bundle();
                bundle.putParcelable("Heroi", personagens);
                intent.putExtras(bundle);
                v.getContext().startActivity(intent);
        }
    });
}


    @Override
    public int getItemCount() {
        return personagensList.size();
    }
}