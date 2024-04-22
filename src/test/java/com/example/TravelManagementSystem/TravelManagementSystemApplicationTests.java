package com.example.TravelManagementSystem;

import com.example.TravelManagementSystem.entities.Activity;
import com.example.TravelManagementSystem.entities.Destination;
import com.example.TravelManagementSystem.entities.Passenger;
import com.example.TravelManagementSystem.entities.TravelPackage;
import com.example.TravelManagementSystem.enums.PassengerType;
import com.example.TravelManagementSystem.exception.InvalidOperationException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class TravelManagementSystemApplicationTests {


	@Test
	void signUpForActivity() {
		// Create passengers
		Passenger passenger1 = new Passenger("John", 1, 100.0, PassengerType.STANDARD);
		Passenger passenger2 = new Passenger("Alice", 2, 200.0, PassengerType.GOLD);
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

		// Test sign up for activity
		assertEquals(1, activity1.getSignedUpPassengers().size());
		assertEquals(1, activity2.getSignedUpPassengers().size());
		assertEquals(1, activity3.getSignedUpPassengers().size());

		// Test deduct balance for gold passenger
		assertEquals(173.0, passenger2.getBalance());

		// Test deduct balance for standard passenger
		assertEquals(50.0, passenger1.getBalance());

		// Test passenger not found exception
		assertThrows(IllegalArgumentException.class, () -> travelPackage.signUpForActivity(4, "Moutain", "Hiking"));

		// Test activity not found exception
		assertThrows(IllegalArgumentException.class, () -> travelPackage.signUpForActivity(5, "City", "Camping"));
	}

	@Test
	void passengerCapacityExceededTest() {
		// Create passengers
		Passenger passenger1 = new Passenger("John", 1, 100.0, PassengerType.STANDARD);
		Passenger passenger2 = new Passenger("Alice", 2, 200.0, PassengerType.GOLD);

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
		TravelPackage travelPackage = new TravelPackage("Adventure Package", 1);
		travelPackage.addPassenger(passenger1);
		assertThrows(InvalidOperationException.class, () -> travelPackage.addPassenger(passenger2));

	}

	@Test
	void activityCapacityExceededTest() {
		// Create passengers
		Passenger passenger1 = new Passenger("John", 1, 100.0, PassengerType.STANDARD);
		Passenger passenger2 = new Passenger("Alice", 2, 200.0, PassengerType.GOLD);
		Passenger passenger3 = new Passenger("Bob", 3, 0.0, PassengerType.PREMIUM);

		// Create activities
		Activity activity1 = new Activity("Hiking", 50.0, 2);

		// Create destinations
		Destination destination1 = new Destination("Mountain");
		destination1.addActivity(activity1);


		// Create travel package
		TravelPackage travelPackage = new TravelPackage("Adventure Package", 5);
		travelPackage.addPassenger(passenger1);
		travelPackage.addPassenger(passenger2);
		travelPackage.addPassenger(passenger3);

		travelPackage.addDestination(destination1);

		// Sign up passengers for activities
		travelPackage.signUpForActivity(1, "Mountain", "Hiking");
		// Sign up passengers for activities
		travelPackage.signUpForActivity(2, "Mountain", "Hiking");
		// Sign up passengers for activities
		assertThrows(InvalidOperationException.class, () -> travelPackage.signUpForActivity(3, "Mountain", "Hiking"));


	}

	@Test
	void balanceBreachedTest() {
		Passenger passenger1 = new Passenger("Alice", 1, 50, PassengerType.GOLD);

		// Create activities
		Activity activity1 = new Activity("Hiking", 50.0, 2);
		Activity activity2 = new Activity("Sightseeing", 60, 2);

		// Create destinations
		Destination destination1 = new Destination("Mountain");
		destination1.addActivity(activity1);
		destination1.addActivity(activity2);


		// Create travel package
		TravelPackage travelPackage = new TravelPackage("Adventure Package", 5);
		travelPackage.addPassenger(passenger1);
		travelPackage.addDestination(destination1);

		// Sign up passengers for activities
		travelPackage.signUpForActivity(1, "Mountain", "Hiking");
		// Sign up passengers for activities
		assertThrows(InvalidOperationException.class, () -> travelPackage.signUpForActivity(1, "Mountain", "Sightseeing"));


	}
	@Test
	void freeEntryForPremiumTest(){
		Passenger passenger1 = new Passenger("Alice", 1, 50, PassengerType.PREMIUM);
		// Create activities
		Activity activity1 = new Activity("Hiking", 60.0, 2);
		Activity activity2 = new Activity("Sightseeing", 60, 2);
		// Create destinations
		Destination destination1 = new Destination("Mountain");
		destination1.addActivity(activity1);
		destination1.addActivity(activity2);


		// Create travel package
		TravelPackage travelPackage = new TravelPackage("Adventure Package", 5);
		travelPackage.addPassenger(passenger1);
		travelPackage.addDestination(destination1);

		// Sign up premium Passenger for free
		travelPackage.signUpForActivity(1, "Mountain", "Hiking");
		travelPackage.signUpForActivity(1, "Mountain", "Sightseeing");

	}

}
