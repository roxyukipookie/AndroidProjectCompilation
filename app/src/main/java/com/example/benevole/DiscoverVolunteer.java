package com.example.benevole;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class DiscoverVolunteer extends AppCompatActivity {
    Button btn_toDonationTab, btn_toForumTab, btn_toBookmark;
    Button detail1, detail2, detail3, bookmark1, bookmark2, bookmark3;;
    ImageView img_home, img_profile;

    String detailsText, title,date,qualifications,time;
    int imageResource;

    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discover_volunteer);

        detail1 = findViewById(R.id.btn_detailCSC);
        detail2 = findViewById(R.id.btn_detailMAR);
        detail3 = findViewById(R.id.btn_detailVPB);

        bookmark1 = findViewById(R.id.button_bookmark);
        bookmark1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveBookmark("Project Baon, A Day Of Volunteer Service", "Jul 23, 2024", "08:00 AM - 12:00 PM", R.drawable.aralpinoy);
                Intent intent = new Intent(DiscoverVolunteer.this, Bookmarks.class);
                startActivity(intent);
            }
        });

        bookmark2 = findViewById(R.id.button_bookmark2);
        bookmark2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveBookmark("Saturday Feeding and Brain Booster Program!", "Jul 27, 2024", "08:00 AM - 11:00 AM", R.drawable.saturdayfeeding);
                Intent intent = new Intent(DiscoverVolunteer.this, VolunteerDetails.class);
                startActivity(intent);
            }
        });

        bookmark3 = findViewById(R.id.button_bookmark3);
        bookmark3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveBookmark("Volunteer Production Buddy", "Jul 26, 2024", "01:00 PM - 04:00 AM", R.drawable.image4);
                Intent intent = new Intent(DiscoverVolunteer.this, VolunteerDetails.class);
                startActivity(intent);
            }
        });

        btn_toForumTab = findViewById(R.id.tab_forum);
        btn_toForumTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toDonations = new Intent(DiscoverVolunteer.this, Forum.class);
                startActivity(toDonations);
            }
        });

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

        img_profile = findViewById(R.id.imageView7);
        img_profile.setOnClickListener(view -> {
            Intent intent = new Intent(DiscoverVolunteer.this, MainActivity.class);
            intent.putExtra("EVENT_NAME", "");
            startActivity(intent);
        });

        detail1.setOnClickListener(view -> {
            Intent intent = createDonationDetailIntent(
                    "Project Baon, A Day Of Volunteer Service",
                    "08:00 AM - 12:00 PM",
                    "Jul 23, 2024",
                    "Ability to engage in physical activities and manage the energy levels of young children.\nStrong verbal and non-verbal communication skills to effectively interact with children, parents, and staff.\nA patient, compassionate, and empathetic demeanor\n",
                    R.drawable.aralpinoy,
                    "Our commitment to education through Project Baon has left a lasting impact on our history. Today, we're building on that legacy. Inspired by the belief that impactful Volunteer Service requires a coordinated effort, Project Baon continues to gather volunteers, creating a positive impact in just one day.\n\nEmbark on a journey of selflessness and compassion, unleashing the power of kindness and generosity. Whether you're lending a helping hand to those in need or spreading love through community service, our Volunteer Service is the perfect platform to give back and make a difference.",
                    "Metro Executive Homes, Maries Village II, Bgy. Mayamot , Antipolo City.",
                    14.6252354,
                    121.1256033
            );
            startActivity(intent);
        });

        detail2.setOnClickListener(view -> {
            Intent intent = createDonationDetailIntent(
                    "Saturday Feeding and Brain Booster Program!",
                    "08:00 AM - 11:00 PM",
                    "Jul 27, 2024",
                    "Volunteers are also encourage to bring snacks, toiletries, coloring books, and crayons to supplement the feeding program.\nAs a precautionary measure please bring alcohol/alcogel. If you have a cold or cough, we discourage you from attending.",
                    R.drawable.saturdayfeeding,
                "After the feeding program for around 400 kids, we have brain booster sessions focused on arts and crafts. These activities allow the kids to hone their creativity while developing a love for Filipino arts and culture. \nWe invite you to join the feeding and brain booster program in the community of Helping Land, Tondo! Kids dance their hearts out before getting their meals. It is definitely a unique exercise that is good for both kids and adults! We serve hearty meals (such as rice with viand, pansit, bread, and banana) in the feeding program. \nAs a volunteer, you will be assigned to any of the following tasks: food preparation, set-up, serving, and cleaning up. You will also be a “Teacher-for-a-day” as you will be assisting the kids with the art activity!",
                    "Helping Complex, Temporary Housing, Brgy 105, Tondo, Manila",
                    14.6221921,
                    120.9535015
            );
            startActivity(intent);
        });

        detail3.setOnClickListener(view -> {
            Intent intent = createDonationDetailIntent(
                    "Volunteer Production Buddy",
                    "01:00 PM - 04:00 PM",
                    "Jul 26, 2024",
                    "An advocate of literacy and independent learning with keen observation skills\n" +
                            "Willing to commit at least 3 hours of his/her time on your chosen timeslot\n"  +
                            "Must be able to travel to Makati City",
                    R.drawable.saturdayfeeding,
                    "Binhi English Literacy Foundation, Inc. is a non-governmental organization (NGO) established in 2008 by a group of dedicated women. This foundation is committed to offering comprehensive learning support programs designed specifically for non-readers and frustrated readers in kindergarten through 3rd grade, attending public elementary schools. \n\nAs we prepare for another BINHI School Year, we are looking for volunteer production buddies to help us sort and assemble materials such as flashcards, worksheets, activity sheets, storybooks, and school supplies for each student to use during the program. Activities may include packing, sorting, laminating, printing, and others. Apart from helping us in the production, consider this also as a way to get to know more about BINHI and our advocacy.",
                    "Unit 201 SEDCCO 1 Bldg., 120 Rada St. Legaspi Village, Makati City",
                    14.5547539,
                    121.0129602
                    );
            startActivity(intent);
        });
    }

    private Intent createDonationDetailIntent(String title, String time, String date, String qualifications, int imageResource, String details, String location, double latitude, double longitude) {
        Intent intent = new Intent(DiscoverVolunteer.this, VolunteerDetails.class);
        intent.putExtra("details", details);
        intent.putExtra("title", title);
        intent.putExtra("time", time);
        intent.putExtra("date", date);
        intent.putExtra("qualifications", qualifications);
        intent.putExtra("location", location);
        intent.putExtra("image", imageResource);
        intent.putExtra("latitude", latitude);
        intent.putExtra("longitude", longitude);
        return intent;
    }

    private void saveBookmark(String title, String date, String time, int imageResource) {
        SharedPreferences sharedPreferences = getSharedPreferences("Bookmarks", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        // Save details to SharedPreferences
        editor.putString("title", title);
        editor.putString("date", date);
        editor.putString("time", time);
        editor.putInt("image", imageResource);
        editor.apply();

        Toast.makeText(this, "Bookmark saved", Toast.LENGTH_SHORT).show();
    }
}