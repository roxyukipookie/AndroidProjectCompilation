package com.example.benevole;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
@SuppressLint("MissingInflatedId")

public class Bookmarks extends AppCompatActivity {

    //@SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookmarks);
        EdgeToEdge.enable(this);

        ImageButton btnBack;

        SharedPreferences sharedPreferences = getSharedPreferences("Bookmarks", MODE_PRIVATE);
        String title = sharedPreferences.getString("title", "No Title");
        String date = sharedPreferences.getString("date", "No Date");
        String time = sharedPreferences.getString("time", "No Time");

       int imageResource = sharedPreferences.getInt("image", R.drawable.aralpinoy);


        // Find and set views
        TextView titleTextView = findViewById(R.id.bookmark_title);
        TextView dateTextView = findViewById(R.id.bookmark_date);
        TextView timeTextView = findViewById(R.id.bookmark_time);
        ImageView imageView = findViewById(R.id.bookmark_image);

        titleTextView.setText(title);
        dateTextView.setText(date);
        timeTextView.setText(time);
        imageView.setImageResource(imageResource);

        btnBack = findViewById(R.id.imageButton);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toMain = new Intent(Bookmarks.this, DiscoverVolunteer.class);
                startActivity(toMain);
            }
        });


    }
}