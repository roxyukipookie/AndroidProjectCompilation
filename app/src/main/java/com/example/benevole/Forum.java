package com.example.benevole;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Forum extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_forum);

        ImageView img_homepage, img_profile, img_discover;

        img_homepage = findViewById(R.id.imageView3);
        img_homepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Forum.this, MainActivity.class);
                startActivity(intent);
            }
        });

        img_profile = findViewById(R.id.imageView7);
        img_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Forum.this, MainActivity.class);
                startActivity(intent);
            }
        });

        img_discover = findViewById(R.id.imageView4);
        img_discover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Forum.this, DiscoverVolunteer.class);
                startActivity(intent);
            }
        });



    }
}