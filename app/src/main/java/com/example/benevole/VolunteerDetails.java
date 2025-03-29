package com.example.benevole;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class VolunteerDetails extends AppCompatActivity {
    TextView tDetails, tTitle, tQualifications, tTime, tDate, tLocation;
    ImageView eventImage;
    Button volunteerButton, attendButton;
    CardView cardView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volunteer_details);

        volunteerButton = findViewById(R.id.btn_volunteer);
        attendButton = findViewById(R.id.btn_attend);
        tDetails = findViewById(R.id.txtDetails);
        tTitle = findViewById(R.id.event_title);
        tQualifications = findViewById(R.id.txtQualifications);
        tDate = findViewById(R.id.event_date);
        tTime = findViewById(R.id.event_time);
        tLocation = findViewById(R.id.event_location);
        eventImage = findViewById(R.id.event_image);
        cardView = findViewById(R.id.card_view);

        double latitude = getIntent().getDoubleExtra("latitude", 0);
        double longitude = getIntent().getDoubleExtra("longitude", 0);

        tLocation.setOnClickListener(view -> {
            Uri mapUri = Uri.parse("geo:" + latitude + "," + longitude + "?q=" + latitude + "," + longitude);
            Intent intent = new Intent(Intent.ACTION_VIEW, mapUri);
            intent.setPackage("com.google.android.apps.maps");
            startActivity(intent);
        });

        if (getIntent().hasExtra("details") && getIntent().hasExtra("image") && getIntent().hasExtra("title") && getIntent().hasExtra("time") && getIntent().hasExtra("date") && getIntent().hasExtra("location")) {
            String detailsText = getIntent().getStringExtra("details");
            String titleText = getIntent().getStringExtra("title");
            String qualificationsText = getIntent().getStringExtra("qualifications");
            String timeText = getIntent().getStringExtra("time");
            String dateText = getIntent().getStringExtra("date");
            String locationText = getIntent().getStringExtra("location");
            int imageResource = getIntent().getIntExtra("image", 0);

            tDetails.setText(detailsText);
            tQualifications.setText(qualificationsText);
            tTime.setText(timeText);
            tDate.setText(dateText);
            tTitle.setText(titleText);
            tLocation.setText(locationText);
            eventImage.setImageResource(imageResource);
        }

        volunteerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cardView.setVisibility(View.VISIBLE);
            }
        });

        attendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processEvent();
                Intent intent = new Intent(VolunteerDetails.this, UserEvents.class);
                startActivity(intent);
            }
        });
    }

    private void processEvent() {
        Event event = new Event(
                tDetails.getText().toString(),
                tTitle.getText().toString(),
                tDate.getText().toString(),
                tTime.getText().toString(),
                tQualifications.getText().toString(),
                getIntent().getIntExtra("image", 0)
        );

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(VolunteerDetails.this);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        int eventCount = sharedPreferences.getInt("event_count", 0) + 1;

        editor.putInt("event_count", eventCount);
        editor.putString("event_" + eventCount + "_details", event.getDetails());
        editor.putString("event_" + eventCount + "_title", event.getTitle());
        editor.putString("event_" + eventCount + "_date", event.getDate());
        editor.putString("event_" + eventCount + "_time", event.getTime());
        editor.putString("event_" + eventCount + "_qualifications", event.getQualifications());
        editor.putInt("event_" + eventCount + "_image", event.getImageResource());

        editor.apply();

        Toast.makeText(VolunteerDetails.this, "Event saved! Event count: " + eventCount, Toast.LENGTH_SHORT).show();
    }
}