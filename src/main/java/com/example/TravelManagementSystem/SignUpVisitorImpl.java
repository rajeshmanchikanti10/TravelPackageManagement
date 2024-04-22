package com.example.TravelManagementSystem;

import com.example.TravelManagementSystem.constants.GenericConstants;
import com.example.TravelManagementSystem.entities.Activity;
import com.example.TravelManagementSystem.entities.Passenger;
import com.example.TravelManagementSystem.enums.PassengerType;
import com.example.TravelManagementSystem.exception.InvalidOperationException;

public class SignUpVisitorImpl implements  SignUpVisitor {

    @Override
    public void visit(Passenger passenger, Activity activity) {
        if ((activity.getSignedUpPassengers().size() < activity.getCapacity())) {
            if (passenger.getPassengerType().equals(PassengerType.PREMIUM)) {
                activity.signUp(passenger);
                return;
            }
            double amountCharged = activity.getCost();
            if (passenger.getPassengerType().equals(PassengerType.GOLD))
                amountCharged -= (GenericConstants.discount * amountCharged);
            if (amountCharged <= passenger.getBalance()) {
                passenger.deductBalance(amountCharged);
                activity.signUp(passenger);
                return;
            }
            throw new InvalidOperationException("Insufficient Balance");
        }
        throw new InvalidOperationException("Capacity of activity Breached");


    }
}
