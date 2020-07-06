package com.example.marvel.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProviders;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.marvel.R;
import com.example.marvel.model.comics.ResultsComics;
import com.example.marvel.viewmodel.ViewModelLogin;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.io.ByteArrayOutputStream;

public class ProfileActivity extends AppCompatActivity {

    private ImageView imageView, imageUser;
    private TextView userName;
    private Button updateImage,updateName;
    private ViewModelLogin viewModelLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Window window = getWindow();
        window.setStatusBarColor(getColor(R.color.colorSplash));
        getWindow().setNavigationBarColor(ContextCompat.getColor(this, R.color.colorSplash));

        imageView = findViewById(R.id.circleImageView);
        userName = findViewById(R.id.username);
        imageUser = findViewById(R.id.image_user);
        updateImage = findViewById(R.id.updateImage);
        updateName = findViewById(R.id.updateName);

        viewModelLogin = ViewModelProviders.of(this).get(ViewModelLogin.class);
        Picasso.get().load(viewModelLogin.getUser().getPhotoUrl()).into(imageView);

        userName.setHint(viewModelLogin.getUser().getDisplayName());

        updateImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                imageView.setDrawingCacheEnabled(true);
                imageView.buildDrawingCache();
                Bitmap bitmap = imageView.getDrawingCache();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
                byte[] dadosImagem = baos.toByteArray();
                StorageReference storageReference = FirebaseStorage.getInstance().getReference();
                StorageReference imagens = storageReference.child("Imagens de Perfil");
                StorageReference imageRef = imagens.child("image.jpeg");
                UploadTask uploadTask = imageRef.putBytes( dadosImagem );

                uploadTask.addOnFailureListener(ProfileActivity.this, new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(ProfileActivity.this, "Image upload failed: " + e.getMessage().toString(),
                        Toast.LENGTH_LONG).show();
                    }
                }).addOnSuccessListener(ProfileActivity.this, new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        Uri url = taskSnapshot.getUploadSessionUri();
                        Toast.makeText(ProfileActivity.this, "Successful image upload: " + url.toString(),
                                Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}