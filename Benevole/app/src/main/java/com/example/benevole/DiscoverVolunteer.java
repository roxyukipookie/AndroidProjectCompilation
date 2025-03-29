package com.example.benevole;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class DiscoverVolunteer extends AppCompatActivity {
    Button btn_toDonationTab;
    Button detail1, detail2, detail3;
    ImageView img_home;

    String detailsText, title,date,qualifications,time;
    int imageResource;

    private List<Event> eventList;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discover_volunteer);

        detail1 = findViewById(R.id.btn_detailCSC);
        detail2 = findViewById(R.id.btn_detailMAR);
        detail3 = findViewById(R.id.btn_detailVPB);

        btn_toDonationTab = findViewById(R.id.tab_donations);
        btn_toDonationTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toDonations = new Intent(DiscoverVolunteer.this, DiscoverDonations.class);
                startActivity(toDonations);
            }
        });

        img_home = findViewById(R.id.imageView3);
        img_home.setOnClickListener(view -> {
            Intent intent = new Intent(DiscoverVolunteer.this, MainActivity.class);
            startActivity(intent);
        });


        detail1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                detailsText = "Our commitment to education through Project Baon has left a lasting impact on our history. Today, we're building on that legacy. Inspired by the belief that impactful Volunteer Service requires a coordinated effort, Project Baon continues to gather volunteers, creating a positive impact in just one day.\n\nEmbark on a journey of selflessness and compassion, unleashing the power of kindness and generosity. Whether you're lending a helping hand to those in need or spreading love through community service, our Volunteer Service is the perfect platform to give back and make a difference.";
                title = "Project Baon, A Day Of Volunteer Service";
                date = "Jul 23, 2024";
                time = "08:00 AM - 12:00 PM";
                qualifications = "Ability to engage in physical activities and manage the energy levels of young children.\nStrong verbal and non-verbal communication skills to effectively interact with children, parents, and staff.\nA patient, compassionate, and empathetic demeanor\n";
                imageResource = R.drawable.aralpinoy;

                Intent intent = new Intent(DiscoverVolunteer.this, VolunteerDetails.class);
                intent.putExtra("details", detailsText);
                intent.putExtra("title", title);
                intent.putExtra("time", time);
                intent.putExtra("date", date);
                intent.putExtra("qualifications", qualifications);
                intent.putExtra("image", imageResource);
                startActivity(intent);
            }
        });

        detail2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                detailsText = "After the feeding program for around 400 kids, we have brain booster sessions focused on arts and crafts. These activities allow the kids to hone their creativity while developing a love for Filipino arts and culture. \nWe invite you to join the feeding and brain booster program in the community of Helping Land, Tondo! Kids dance their hearts out before getting their meals. It is definitely a unique exercise that is good for both kids and adults! We serve hearty meals (such as rice with viand, pansit, bread, and banana) in the feeding program. \nAs a volunteer, you will be assigned to any of the following tasks: food preparation, set-up, serving, and cleaning up. You will also be a “Teacher-for-a-day” as you will be assisting the kids with the art activity!";
                title = "Saturday Feeding and Brain Booster Program!";
                date = "Jul 27, 2024";
                time = "08:00 AM - 11:00 PM";
                qualifications = "Volunteers are also encourage to bring snacks, toiletries, coloring books, and crayons to supplement the feeding program.\nAs a precautionary measure please bring alcohol/alcogel. If you have a cold or cough, we discourage you from attending.";
                imageResource = R.drawable.saturdayfeeding;

                Intent intent = new Intent(DiscoverVolunteer.this, VolunteerDetails.class);
                intent.putExtra("details", detailsText);
                intent.putExtra("title", title);
                intent.putExtra("time", time);
                intent.putExtra("date", date);
                intent.putExtra("qualifications", qualifications);
                intent.putExtra("image", imageResource);
                startActivity(intent);
            }
        });

        detail3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                detailsText = "Binhi English Literacy Foundation, Inc. is a non-governmental organization (NGO) established in 2008 by a group of dedicated women. This foundation is committed to offering comprehensive learning support programs designed specifically for non-readers and frustrated readers in kindergarten through 3rd grade, attending public elementary schools. \n\nAs we prepare for another BINHI School Year, we are looking for volunteer production buddies to help us sort and assemble materials such as flashcards, worksheets, activity sheets, storybooks, and school supplies for each student to use during the program. Activities may include packing, sorting, laminating, printing, and others. Apart from helping us in the production, consider this also as a way to get to know more about BINHI and our advocacy.";
                title = "Volunteer Production Buddy";
                date = "Jul 26, 2024";
                time = "01:00 PM - 04:00 PM";
                qualifications = "An advocate of literacy and independent learning with keen observation skills\n" +
                        "Willing to commit at least 3 hours of his/her time on your chosen timeslot\n" +
                        "Must be able to travel to Makati City";
                imageResource = R.drawable.image4;

                Intent intent = new Intent(DiscoverVolunteer.this, VolunteerDetails.class);
                intent.putExtra("details", detailsText);
                intent.putExtra("title", title);
                intent.putExtra("time", time);
                intent.putExtra("date", date);
                intent.putExtra("qualifications", qualifications);
                intent.putExtra("image", imageResource);
                startActivity(intent);
            }
        });
    }
}