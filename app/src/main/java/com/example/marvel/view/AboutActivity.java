package com.example.marvel.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.Toast;
import com.example.marvel.R;
import static android.widget.Toast.makeText;

public class AboutActivity extends AppCompatActivity {

    ImageView goot;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        Window window = getWindow();
        window.setStatusBarColor(getColor(R.color.colorSplash));
        getWindow().setNavigationBarColor(ContextCompat.getColor(this, R.color.colorSplash));

        goot = findViewById(R.id.imageGoot);

        goot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeText(context, R.string.goot, Toast.LENGTH_LONG).show();
                playSound();
            }
        });
        goot.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                playSoundLong();
                return true;
            }
        });
    }
    private void playSound() {
        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.groot);
        mediaPlayer.start();
    }
    private void playSoundLong() {
        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.groooot);
        mediaPlayer.start();
    }
}