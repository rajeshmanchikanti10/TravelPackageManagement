package com.example.TravelManagementSystem.entities;

import com.example.TravelManagementSystem.enums.PassengerType;
import com.example.TravelManagementSystem.SignUpVisitorImpl;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public class Passenger {
    private Integer passengerNumber;
    private String name;
    private Double balance;
    private PassengerType passengerType;

    public Passenger(String name, int passengerNumber, double balance, PassengerType passengerType) {
        this.name = name;
        this.passengerNumber = passengerNumber;
        this.balance = balance;
        this.passengerType = passengerType;
    }

    public String getName() {
        return this.name;
    }

    public double getBalance() {
        return this.balance;
    }

    public int getPassengerNumber() {
        return this.passengerNumber;
    }

    public PassengerType getPassengerType() {
        return this.passengerType;
    }

    public void deductBalance(double amount) {
        balance -= amount;
    }

    public void signUpForActivity(Activity activity) {
        SignUpVisitorImpl signUpVisitor = new SignUpVisitorImpl();
        activity.accept(this, signUpVisitor);
    }

    public void printDetails() {
        System.out.println("Name: " + getName());
        System.out.println("Number: " + getPassengerNumber());
        System.out.println("Type: " + getPassengerType());
        System.out.println("Balance: " + getBalance());
    }


}