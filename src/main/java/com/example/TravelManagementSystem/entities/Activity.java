package com.example.TravelManagementSystem.entities;

import com.example.TravelManagementSystem.SignUpVisitor;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.ArrayList;
import java.util.List;
@Builder
@AllArgsConstructor
public class Activity {

    private Integer activityId;
    private String name;
    private double cost;
    private int capacity;
    private List<Integer> signedUpPassengers;
    public Activity(String name, double cost, int capacity) {
        this.name = name;
        this.cost = cost;
        this.capacity = capacity;
        this.signedUpPassengers = new ArrayList<>();
    }
    public String getName() {
        return this.name;
    }

    public double getCost() {
        return this.cost;
    }

    public int getCapacity() {
        return this.capacity;
    }
    public List<Integer> getSignedUpPassengers(){
        return this.signedUpPassengers;
    }
    public void signUp(Passenger passenger){
        signedUpPassengers.add(passenger.getPassengerNumber());
    }
    public void accept(Passenger passenger, SignUpVisitor visitor) {
        visitor.visit(passenger, this);
    }


}
