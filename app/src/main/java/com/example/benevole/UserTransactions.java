package com.example.benevole;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class UserTransactions extends AppCompatActivity {
    ImageView img_home, img_discover;
    ImageButton img_back;

    private static List<Double> transactions = new ArrayList<>();
    private LinearLayout eventsContainer;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_transactions);

        eventsContainer = findViewById(R.id.events_container);
        displayTransactions();

        img_home = findViewById(R.id.imageView3);
        img_home.setOnClickListener(view -> {
            Intent intent = new Intent(UserTransactions.this, MainActivity.class);
            startActivity(intent);
        });

        img_back = findViewById(R.id.imageButton);
        img_back.setOnClickListener(view -> {
            Intent intent = new Intent(UserTransactions.this, MainActivity.class);
            startActivity(intent);
        });

        img_discover = findViewById(R.id.imageView4);
        img_discover.setOnClickListener(view -> {
            Intent intent = new Intent(UserTransactions.this, DiscoverVolunteer.class);
            intent.putExtra("EVENT_NAME", "");
            startActivity(intent);
        });
    }

    private void displayTransactions() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        int transactionCount = sharedPreferences.getInt("transaction_count", 0);

        eventsContainer.removeAllViews();
        for (int i = 1; i <= transactionCount; i++) {
            String amount = sharedPreferences.getString("transaction_" + i + "_amount", "0");
            String eventName = sharedPreferences.getString("transaction_" + i + "_event_name", "Unknown Event");
            String eventImage = sharedPreferences.getString("transaction_" + i + "_event_image", "0");

            View transactionView = getLayoutInflater().inflate(R.layout.transaction_item, null);

            TextView transactionAmount = transactionView.findViewById(R.id.transaction_amount);
            TextView transactionEventName = transactionView.findViewById(R.id.transaction_event_name);
            ImageView transactionEventImage = transactionView.findViewById(R.id.transaction_event_image);

            transactionAmount.setText("Donation: " + amount);
            transactionEventName.setText("Event: " + eventName);
            transactionEventImage.setImageResource(Integer.parseInt(eventImage));

            eventsContainer.addView(transactionView);
        }
    }

}