package com.example.marvel.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.ui.AppBarConfiguration;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.marvel.R;
import com.example.marvel.viewmodel.ViewModelLogin;
import com.google.android.material.navigation.NavigationView;
import com.squareup.picasso.Picasso;


public class HomeActivity extends AppCompatActivity {

    private Button personagens, criadores, eventos, quadrinhos;
    private FragmentManager manager;
    private DrawerLayout drawerLayout;
    private ViewModelLogin viewModelLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawer_home);

        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(getColor(R.color.backred));
        getWindow().setNavigationBarColor(ContextCompat.getColor(this, R.color.backred));

        viewModelLogin = ViewModelProviders.of(this).get(ViewModelLogin.class);


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

        View headerView = navigationView.getHeaderView(0);
        TextView nav_user = headerView.findViewById(R.id.user_name);
        TextView nav_email = headerView.findViewById(R.id.user_email);
        ImageView nav_image = headerView.findViewById(R.id.image_user);

        nav_user.setText(viewModelLogin.getUser().getDisplayName());
        nav_email.setText(viewModelLogin.getUser().getEmail());
        Picasso.get().load(viewModelLogin.getUser().getPhotoUrl()).into(nav_image);

        manager = getSupportFragmentManager();
        viewModelLogin.getExitresponse().observe(this, aBoolean -> {
            if (aBoolean) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            } else {
                Toast.makeText(this, R.string.error_exiting, Toast.LENGTH_SHORT).show();
            }
        });
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
              @Override
              public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                  int id = item.getItemId();

                  if (id == R.id.nav_sobre) {
                      startActivity(new Intent(getApplicationContext(), AboutActivity.class));
                  }
                if (id == R.id.nav_favoritos) {
                startActivity(new Intent(getApplicationContext(), FavoritesActivity.class));
                } else if (id == R.id.btn_sair) {
                      viewModelLogin.logOff();
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
              }
        });
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
}