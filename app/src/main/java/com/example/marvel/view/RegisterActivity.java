package com.example.marvel.view;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.marvel.R;

import static android.widget.Toast.makeText;

public class RegisterActivity extends AppCompatActivity {

    Button salvar;
    EditText nome, sobrenome, email, senha;
    Context context = this;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        nome = findViewById(R.id.nome);
        sobrenome = findViewById(R.id.sobrenome);
        email = findViewById(R.id.email);
        senha = findViewById(R.id.senha);
        salvar = findViewById(R.id.buttonSalvar);

        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (todosPreenchidos(nome, sobrenome, email, senha)) {
                    Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                    startActivity(intent);
                } else {
                    makeText(context, "Por favor preencha todos os campos!", Toast.LENGTH_LONG).show();
                }
            }

            private boolean todosPreenchidos(EditText... listaDeCamposDeTexto) {
                for (EditText campoDeTexto : listaDeCamposDeTexto) {
                    if (campoDeTexto.getText().toString().isEmpty()) return false;
                }
                return true;
            }
        });
    }
}