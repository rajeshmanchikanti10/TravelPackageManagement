package com.example.TravelManagementSystem;

import com.example.TravelManagementSystem.entities.Activity;
import com.example.TravelManagementSystem.entities.Passenger;

public interface SignUpVisitor {
    void visit(Passenger passenger, Activity activity);
}
