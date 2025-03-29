package com.example.benevole;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DiscoverDonations extends AppCompatActivity {
    Button btn_volunteerTab;
    Button detail1, detail2;
    ImageView img_home;

    String textDetails, textTitle, textDate, textPhone;
    int imageResource;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discover_donations);

        detail1 = findViewById(R.id.btn_detailSST);
        detail2 = findViewById(R.id.btn_detailEES);

        btn_volunteerTab = findViewById(R.id.tab_volunteer);
        btn_volunteerTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DiscoverDonations.this, DiscoverVolunteer.class);
                startActivity(intent);
            }
        });

        img_home = findViewById(R.id.imageView3);
        img_home.setOnClickListener(view -> {
            Intent intent = new Intent(DiscoverDonations.this, MainActivity.class);
            startActivity(intent);
        });

        detail1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textDetails = "Media Educators of Mindanao (MEM) will be launching its new Skwela Salida community film literacy program in July. It aims to aims to turn film screenings from passive viewing to active learning experiences by connecting personal reflection to social responsibility through its Showing-Synthesis-Social Action framework. The program is mainly implemented through a web-based app which features a catalog of regional short films with accompanying study guides created by volunteers. The online platform is a community learning environment where teachers and students can learn about the film’s creative and social values and be prompted to do civic engagement through volunteering.\n\nWhile this educational technology requires internet connectivity, the program provides an offline alternative to reach underserved communities. We do this through a Skwela Salida Ambassador course. It is a 2-day intensive workshop wherein teachers are trained how to use the films and the lessons using the Skwela Salida framework in schools and communities without having to use the web-app.\n\nThe donation will be used to subsidize the first cohort of 20-25 teachers from the Davao region. The fund will be used to pay for rental of workshop space, meals, and teaching materials.";
                textTitle = "Skwela Salida Teachers Camp";
                textDate = "Jul 31, 2024";
                textPhone = "09189150621";
                imageResource = R.drawable.skwelasalida;

                Intent intent = new Intent(DiscoverDonations.this, DonationDetails.class);
                intent.putExtra("details_key", textDetails);
                intent.putExtra("title_key", textTitle);
                intent.putExtra("date_key", textDate);
                intent.putExtra("phone_key", textPhone);
                intent.putExtra("image_key", imageResource);
                startActivity(intent);
            }
        });

        detail2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textDetails = "The donation would go toward purchasing items such as pencils, erasers, notebooks, papers, markers, scissors, crayons and other gadgets necessary for their schooling. Every donation is an investment in the future of every scholar in the community. With your help, our scholars can look forward to having more resources while pursuing their dreams.  \n" +
                        "\n" +
                        "Beneficiaries will be 2KK's Yapak leaders and the kids/tutees from Payatas, Sampaloc and Smokey Mountain Tondo.";
                textTitle = "Education with heart, Excellence from the start";
                textDate = "Sep 15, 2024";
                textPhone = "09665449631";
                imageResource = R.drawable.education;

                Intent intent = new Intent(DiscoverDonations.this, DonationDetails.class);
                intent.putExtra("details_key", textDetails);
                intent.putExtra("title_key", textTitle);
                intent.putExtra("date_key", textDate);
                intent.putExtra("phone_key", textPhone);
                intent.putExtra("image_key", imageResource);
                startActivity(intent);
            }
        });
    }
}