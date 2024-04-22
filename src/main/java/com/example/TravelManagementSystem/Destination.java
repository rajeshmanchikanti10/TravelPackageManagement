package com.example.TravelManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class Destination {
    private String name;
    private List<Activity> activities;
    public Destination(String name) {
        this.name = name;
        this.activities = new ArrayList<>();
    }

    public void addActivity(Activity activity) {
        activities.add(activity);
    }

    public String getName() {
        return this.name;

    }

    public List<Activity> getActivities() {
        return this.activities;
    }

}
