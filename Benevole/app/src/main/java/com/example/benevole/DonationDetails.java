package com.example.benevole;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class DonationDetails extends AppCompatActivity {
    TextView tTitle, tDate, tPhone, tDetails;
    ImageView eventImage;
    Button donateButton, payButton;
    CardView cardView;
    LinearLayout eventsContainer;


    private EditText editTextAmount, editTextCardHolder, editTextCardNumber, editTextExpiryMonth, editTextExpiryYear;
    private Button btnPay;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation_details);

        tDetails = findViewById(R.id.txtDetails);
        tTitle = findViewById(R.id.event_title);
        tDate = findViewById(R.id.txt_date);
        tPhone = findViewById(R.id.txt_contact);
        eventImage = findViewById(R.id.event_image);

        editTextAmount = findViewById(R.id.editTextNumberDecimal);
        editTextCardHolder = findViewById(R.id.editTextCardHolder);
        editTextCardNumber = findViewById(R.id.editTextCardNumber);
        editTextExpiryMonth = findViewById(R.id.editTextExpiryMonth);
        editTextExpiryYear = findViewById(R.id.editTextExpiryYear);

        btnPay = findViewById(R.id.btn_pay);
        cardView = findViewById(R.id.card_view);

        donateButton = findViewById(R.id.btn_donate);
        donateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cardView.setVisibility(View.VISIBLE);
            }
        });

        payButton = findViewById(R.id.btn_pay);
        payButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processPayment();
                Intent intent = new Intent(DonationDetails.this, UserTransactions.class);
                startActivity(intent);
            }
        });

        if(getIntent().hasExtra("details_key") && getIntent().hasExtra("title_key") && getIntent().hasExtra("image_key") && getIntent().hasExtra("date_key") && getIntent().hasExtra("phone_key")) {
            String detailsText = getIntent().getStringExtra("details_key");
            String titleText = getIntent().getStringExtra("title_key");
            String dateText = getIntent().getStringExtra("date_key");
            String phoneText = getIntent().getStringExtra("phone_key");
            int imageResource = getIntent().getIntExtra("image_key", 0);

            tDetails.setText(detailsText);
            tTitle.setText(titleText);
            tPhone.setText(phoneText);
            tDate.setText(dateText);
            eventImage.setImageResource(imageResource);
        }
    }

    private void processPayment() {
        String amountStr = editTextAmount.getText().toString();
        if (!amountStr.isEmpty()) {
            double amount = Double.parseDouble(amountStr);
            if (amount > 0) {
                String cardHolder = editTextCardHolder.getText().toString();
                String cardNumber = editTextCardNumber.getText().toString();
                String expiryMonth = editTextExpiryMonth.getText().toString();
                String expiryYear = editTextExpiryYear.getText().toString();

                // Record the transaction
                recordTransaction(amount);
                Toast.makeText(DonationDetails.this, "Payment was made successfully", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(DonationDetails.this, "Please enter a valid amount", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(DonationDetails.this, "Please enter an amount", Toast.LENGTH_SHORT).show();
        }
    }

    private void recordTransaction(double amount) {
        String eventName = tTitle.getText().toString();
        String eventImage = Integer.toString(getIntent().getIntExtra("image_key", 0));

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        int transactionCount = sharedPreferences.getInt("transaction_count", 0);
        transactionCount++;
        editor.putInt("transaction_count", transactionCount);
        editor.putString("transaction_" + transactionCount + "_amount", String.valueOf(amount));
        editor.putString("transaction_" + transactionCount + "_event_name", eventName);
        editor.putString("transaction_" + transactionCount + "_event_image", eventImage);

        editor.apply();
    }

}