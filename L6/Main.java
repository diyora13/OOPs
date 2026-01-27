import L6.*;

public class Main {
    void main() {
      // -------- 1) Upcasting --------
    Ride r1 = new CarRide("City Car", 10);
    r1.print(); // Name: City Car Distance: 10 Fare: 120

    Ride r2 = new BikeRide("City Bike", 10);
    r2.print(); // Name: City Bike Distance: 10 Fare: 50

    // -------- 2) Dynamic dispatch --------
    Ride[] rides = { r1, r2 };
    for (Ride r : rides) {
        r.print(); // Each prints child fare (120 for car, 50 for bike)
    }

    // -------- 3) Change distance, see dynamic fare update --------
    r1.setDistance(15);
    r1.print(); // Name: City Car Distance: 15 Fare: 180

    r2.setDistance(15);
    r2.print(); // Name: City Bike Distance: 15 Fare: 75

    // -------- 4) Classic downcasting --------
    // Correct downcast
    if (r1 instanceof CarRide) {
        CarRide c = (CarRide) r1;
        c.printCar(); // Name: City Car Distance: 15 Fare: 180 Type: Car
    }

    // Wrong downcast (kept commented; will crash at runtime)
    // CarRide wrong = (CarRide) r2; // Error

    // -------- 5) Safe downcasting using instanceof --------
    if (r2 instanceof BikeRide) {
        BikeRide b = (BikeRide) r2;
        b.printBike(); // Name: City Bike Distance: 15 Fare: 75 Type: Bike
    }

    // -------- 6) Java 17 pattern matching for instanceof --------
    Ride random = r1; // Can assign r2 to test different behavior

    if (random instanceof CarRide) {
        CarRide c = (CarRide) random;
        c.printCar(); // prints car info
    } else if (random instanceof BikeRide) {
        BikeRide b = (BikeRide) random;
        b.printBike(); // prints bike info
    } else {
        random.print();
    }

    // -------- 7) Loop polymorphism with pattern matching --------
    for (Ride r : rides) {
        if (r instanceof CarRide c) {
            c.printCar(); // Car
        } else if (r instanceof BikeRide b) {
            b.printBike(); // Bike
        } else {
            r.print();
        }
    }
  }
}
