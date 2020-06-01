package com.example.marvel.view;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;

import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.marvel.R;
import com.example.marvel.drawer.FragDeslizaMostra;
import com.google.android.material.navigation.NavigationView;


public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    Button personagens;
    Button quadrinhos;
    ImageView hambugue;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setContentView(R.layout.navegation_drawer);

        hambugue = findViewById(R.id.menu_hamburger);
        personagens = findViewById(R.id.buttonPersonagens);
        quadrinhos = findViewById(R.id.buttonQuadrinhos);
        hambugue = findViewById(R.id.menu_hamburger);
        navigationView = findViewById(R.id.nav_view);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView.setNavigationItemSelectedListener(this);
        manager = getSupportFragmentManager();

        hambugue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            drawerLayout.openDrawer(GravityCompat.START);
            }
        });
        quadrinhos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), QuadrinhosActivity.class);
                startActivity(intent);
            }
        });
        personagens.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PersonagensActivity.class);
                startActivity(intent);
            }
        });
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case R.id.deslizamostra:
                vaPara(new FragDeslizaMostra());
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return false;
    }

    public void vaPara(Fragment fragment) {
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.nav_home, fragment);
        transaction.commit();
    }
}