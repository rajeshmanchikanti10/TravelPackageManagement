package com.example.TravelManagementSystem;

public class Passenger {
    private String name;
    private Integer passengerNumber;
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