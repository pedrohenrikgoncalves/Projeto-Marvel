package com.example.marvel.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;

import com.example.marvel.R;

public class SplashActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 6500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent i = new Intent(getBaseContext(), LoginActivity.class);
                startActivity(i);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }

    @Override
    protected void onResume() {
        super.onResume();
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                playSound();
            }
        }, 500);
    }

    private void playSound() {
        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.marvel_music);
        mediaPlayer.start();
    }
}
