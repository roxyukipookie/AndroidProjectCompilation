package com.example.benevole;

public class Event {
    private String details;
    private String title;
    private String date;
    private String time;
    private String qualifications;
    private int imageResource;

    // Constructor, getters, and setters
    public Event(String details, String title, String date, String time, String qualifications, int imageResource) {
        this.details = details;
        this.title = title;
        this.date = date;
        this.time = time;
        this.qualifications = qualifications;
        this.imageResource = imageResource;
    }

    public Event(String title, int imageResource) {
        this.title = title;
        this.imageResource = imageResource;
    }

    // Getters and setters
    public String getDetails() { return details; }
    public String getTitle() { return title; }
    public String getDate() { return date; }
    public String getTime() { return time; }
    public String getQualifications() { return qualifications; }
    public int getImageResource() { return imageResource; }
}
