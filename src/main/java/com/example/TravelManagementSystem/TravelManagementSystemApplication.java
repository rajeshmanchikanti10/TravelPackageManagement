package com.example.TravelManagementSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TravelManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(TravelManagementSystemApplication.class, args);
		Passenger passenger1 = new Passenger("John", 1, 100.0, PassengerType.STANDARD);
		Passenger passenger2 = new Passenger("Alice", 2, 200.0, PassengerType.PREMIUM);
		Passenger passenger3 = new Passenger("Bob", 3, 0.0, PassengerType.PREMIUM);
		// Create activities
		Activity activity1 = new Activity("Hiking", 50.0, 10);
		Activity activity2 = new Activity("Sightseeing", 30.0, 20);
		Activity activity3 = new Activity("Cruise", 100.0, 5);

		// Create destinations
		Destination destination1 = new Destination("Mountain");
		destination1.addActivity(activity1);
		Destination destination2 = new Destination("City");
		destination2.addActivity(activity2);
		destination2.addActivity(activity3);
		// Create travel package
		TravelPackage travelPackage = new TravelPackage("Adventure Package", 5);
		travelPackage.addPassenger(passenger1);
		travelPackage.addPassenger(passenger2);
		travelPackage.addPassenger(passenger3);
		travelPackage.addDestination(destination1);
		travelPackage.addDestination(destination2);

		// Sign up passengers for activities
		travelPackage.signUpForActivity(1, "Mountain", "Hiking");
		travelPackage.signUpForActivity(2, "City", "Sightseeing");
		travelPackage.signUpForActivity(3, "City", "Cruise");
		// Print itinerary
		travelPackage.printItinerary();

		// Print passenger list
		travelPackage.printPassengerList();

		// Print available activities
		travelPackage.printAvailableActivities();



	}

}
