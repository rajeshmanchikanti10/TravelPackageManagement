package com.example.TravelManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class Activity {
    private String name;
    private double cost;
    private int capacity;
    private List<Passenger> signedUpPassengers;
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
    public List<Passenger> getSignedUpPassengers(){
        return this.signedUpPassengers;
    }
    public void signUp(Passenger passenger){
        signedUpPassengers.add(passenger);
    }
    public void accept(Passenger passenger, SignUpVisitor visitor) {
        visitor.visit(passenger, this);
    }


}
