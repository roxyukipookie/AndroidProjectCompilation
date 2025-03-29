package com.example.benevole;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    ImageView img_discover, img_events, img_transactions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img_discover = findViewById(R.id.imageView4);
        img_events = findViewById(R.id.image1);
        img_transactions = findViewById(R.id.image2);

        img_discover.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, DiscoverVolunteer.class);
            intent.putExtra("EVENT_NAME", "");
            startActivity(intent);
        });

        img_events.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, UserEvents.class);
            startActivity(intent);
        });

        img_transactions.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, UserTransactions.class);
            startActivity(intent);
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        /*clear SharedPreferences when the application stops
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();*/
    }
}