package com.example.TravelManagementSystem.entities;

import com.example.TravelManagementSystem.enums.State;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.ArrayList;
import java.util.List;
@Builder
@AllArgsConstructor
public class Destination {

    private String name;
    private List<Activity> activities;
    private State state;
    public Destination(String name) {
        this.name = name;
        this.activities = new ArrayList<>();
        this.state = State.ACTIVE;
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
    public void updateState(State state){
        this.state = state;
    }

}
