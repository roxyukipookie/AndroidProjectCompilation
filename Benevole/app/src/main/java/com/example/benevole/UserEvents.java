package com.example.benevole;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class UserEvents extends AppCompatActivity {
    LinearLayout eventsContainer;
    ImageView img_home, img_discover;
    ImageButton img_back;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_events);

        img_home = findViewById(R.id.imageView3);
        img_home.setOnClickListener(view -> {
            Intent intent = new Intent(UserEvents.this, MainActivity.class);
            startActivity(intent);
        });

        img_back = findViewById(R.id.imageButton);
        img_back.setOnClickListener(view -> {
            Intent intent = new Intent(UserEvents.this, MainActivity.class);
            startActivity(intent);
        });

        img_discover = findViewById(R.id.imageView4);
        img_discover.setOnClickListener(view -> {
            Intent intent = new Intent(UserEvents.this, DiscoverVolunteer.class);
            intent.putExtra("EVENT_NAME", "");
            startActivity(intent);
        });

        eventsContainer = findViewById(R.id.events_container);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        int eventCount = sharedPreferences.getInt("event_count", 0);

        for (int i = 1; i <= eventCount; i++) {
            String details = sharedPreferences.getString("event_" + i + "_details", "No details available");
            String title = sharedPreferences.getString("event_" + i + "_title", "No title available");
            String date = sharedPreferences.getString("event_" + i + "_date", "No date available");
            String time = sharedPreferences.getString("event_" + i + "_time", "No time available");
            String qualifications = sharedPreferences.getString("event_" + i + "_qualifications", "No qualifications available");
            int imageResource = sharedPreferences.getInt("event_" + i + "_image", 0);

            View eventView = getLayoutInflater().inflate(R.layout.event_item_list, null);

            TextView eventName = eventView.findViewById(R.id.event_name);
            TextView eventDate = eventView.findViewById(R.id.event_date);
            TextView eventTime = eventView.findViewById(R.id.event_time);
            ImageView eventImage = eventView.findViewById(R.id.event_image);

            eventName.setText(title);
            eventDate.setText(date);
            eventTime.setText(time);
            eventImage.setImageResource(imageResource);

            eventsContainer.addView(eventView);
        }
    }
}
