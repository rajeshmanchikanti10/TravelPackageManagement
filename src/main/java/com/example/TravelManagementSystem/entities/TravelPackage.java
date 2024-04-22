package com.example.TravelManagementSystem.entities;

import com.example.TravelManagementSystem.entities.Activity;
import com.example.TravelManagementSystem.entities.Destination;
import com.example.TravelManagementSystem.entities.Passenger;
import com.example.TravelManagementSystem.exception.InvalidOperationException;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Builder
@AllArgsConstructor
public class TravelPackage {
    //can generate unique packageId

    //name is unique identifier
    private String name;
    private Integer passengerCapacity;
    private List<Passenger> passengerList;
    private List<Destination> destinations;

    public TravelPackage(String name, int passengerCapacity) {
        this.name = name;
        this.passengerCapacity = passengerCapacity;
        this.passengerList = new ArrayList<>();
        this.destinations = new ArrayList<>();
    }

    public void addPassenger(Passenger passenger) {
        if (passengerList.size() < passengerCapacity) {
            passengerList.add(passenger);
        } else
            throw new InvalidOperationException("Passenger Capacity Reached");

    }

    public void addDestination(Destination destination) {
        destinations.add(destination);
    }

    public void signUpForActivity(int passengerNumber, String destinationName,String activityName) {
        Passenger passenger = passengerList.stream()
                .filter(pass -> passengerNumber == pass.getPassengerNumber()).findFirst().orElseThrow(() -> new IllegalArgumentException("Passenger not found with passId: " + passengerNumber));
        Optional<Activity> optionalActivity = destinations.stream()
                .filter(destination -> destinationName == destination.getName())
                .flatMap(destination -> destination.getActivities().stream())
                .filter(activity -> activity.getName().equals(activityName))
                .findFirst();
        optionalActivity.ifPresentOrElse(
                passenger::signUpForActivity,
                () -> new IllegalArgumentException("Activity not found: " + activityName)
        );

    }

    public void printItinerary() {
        System.out.println("Travel Package: " + name);
        for (Destination destination : destinations) {
            System.out.println("Destination: " + destination.getName());
            for (Activity activity : destination.getActivities()) {
                System.out.println("Activity: " + activity.getName());
                System.out.println("Cost: " + activity.getCost());
                System.out.println("Capacity: " + activity.getCapacity());
            }
        }
    }
    public void printPassengerList() {
        System.out.println("Travel Package: " + name);
        System.out.println("Passenger Capacity: " + passengerCapacity);
        System.out.println("Number of Passengers Enrolled: " + passengerList.size());
        for (Passenger passenger : passengerList) {
            passenger.printDetails();
        }
    }
    public void printPassengerDetails(int passengerNumber) {
        for (Passenger passenger : passengerList) {
            if (passenger.getPassengerNumber() == passengerNumber) {
                passenger.printDetails();
                return;
            }
        }
        throw new IllegalArgumentException("Passenger not found with passId: " + passengerNumber);
    }
    public void printAvailableActivities() {
        System.out.println("Available Activities:");
        for (Destination destination : destinations) {
            for (Activity activity : destination.getActivities()) {
                if ((activity.getCapacity()- activity.getSignedUpPassengers().size()) > 0) {
                    System.out.println("Destination: " + destination.getName());
                    System.out.println("Activity: " + activity.getName());
                    System.out.println("Cost: " + activity.getCost());
                    System.out.println("Remaining Capacity: " + (activity.getCapacity()-activity.getSignedUpPassengers().size()));
                }
            }
        }
    }


}
