package com.example.TravelManagementSystem.service;

import com.example.TravelManagementSystem.entities.TravelPackage;

public class TravelPackageManager {
    public void addTravelPackage(TravelPackage travelPackage) {

    }

    public TravelPackage getTravelPackage(String name) {
        return TravelPackage.builder().build();
    }

    public void signUpUserForActivityInPackage(String name, int passengerNumber, String destinationName, String activityName) {
        getTravelPackage(name).signUpForActivity(passengerNumber, destinationName, activityName);
    }


}
