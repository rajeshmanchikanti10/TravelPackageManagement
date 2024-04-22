package com.example.TravelManagementSystem.service;

import com.example.TravelManagementSystem.entities.Activity;
import com.example.TravelManagementSystem.enums.State;
import com.example.TravelManagementSystem.entities.Destination;

//A travel package can have list of destination
// Each destination can be in different package
public class DestinationService {
    public void addDestination(Destination destination) {
        // convert to DTO
        // write to DB
    }

    public void updateDestination(Destination destination) {

    }

    public Destination getDestination(String destinationName) {
        return Destination.builder().build();
    }

    public void updateDestinationState(String destinationName, State state) {
        Destination destination = getDestination(destinationName);
        destination.updateState(state);
        //update in DB
    }

    public void addActivity(String destinationName, Activity activity) {
        getDestination(destinationName).addActivity(activity);
    }

}
