package com.example.marvel.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import androidx.fragment.app.FragmentManager;
import androidx.navigation.ui.AppBarConfiguration;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.example.marvel.R;
import com.google.android.material.navigation.NavigationView;


public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Button personagens, criadores, eventos, quadrinhos;
    private FragmentManager manager;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawer_home);

        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(getColor(R.color.backred));


        Toolbar toolbar = findViewById(R.id.app_bar);

        personagens = findViewById(R.id.buttonPersonagens);
        quadrinhos = findViewById(R.id.buttonQuadrinhos);
        criadores = findViewById(R.id.buttonCriadores);
        eventos = findViewById(R.id.buttonEventos);

        drawerLayout = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);

        setSupportActionBar(toolbar);

        AppBarConfiguration mAppBarConfiguration = new AppBarConfiguration.Builder()
                .setDrawerLayout(drawerLayout)
                .build();


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        );

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        manager = getSupportFragmentManager();

        quadrinhos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ComicsActivity.class);
                startActivity(intent);
            }
        });
        personagens.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CharactersActivity.class);
                startActivity(intent);
            }
        });
        criadores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CreatorsActivity.class);
                startActivity(intent);
            }
        });
        eventos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 Intent intent = new Intent(getApplicationContext(), EventsActivity.class);
                 startActivity(intent);
            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_favoritos) {
            startActivity(new Intent(this, CharactersActivity.class));
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}