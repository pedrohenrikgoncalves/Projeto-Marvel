package com.example.marvel.adapter;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.marvel.R;


public class ViewHolderPersonagens extends RecyclerView.ViewHolder {

        TextView heroi;
        TextView nome;
        CardView cardView;

    public ViewHolderPersonagens(@NonNull View itemView) {
        super(itemView);

        heroi = itemView.findViewById(R.id.text_heroi);
        nome = itemView.findViewById(R.id.text_nome);
        cardView = itemView.findViewById(R.id.card_view);
    }
}
