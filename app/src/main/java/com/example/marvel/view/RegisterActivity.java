package com.example.marvel.view;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.marvel.R;

import static android.widget.Toast.makeText;

public class RegisterActivity extends AppCompatActivity {

    Button save;
    EditText name, confirmpassword, email, password;
    Context context = this;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Window window = getWindow();
        window.setStatusBarColor(getColor(R.color.loginColor));
        getWindow().setNavigationBarColor(ContextCompat.getColor(this, R.color.loginColor));
        name = findViewById(R.id.username);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        confirmpassword = findViewById(R.id.confirm_password);
        save = findViewById(R.id.buttonSave);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (todosPreenchidos(name, email, password, confirmpassword)) {
                    Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                    startActivity(intent);
                } else {
                    makeText(context, "Please! Fill in all the fields.", Toast.LENGTH_LONG).show();
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