package L6;

public class BikeRide extends Ride {

    public BikeRide(String name, int distance) {
        super(name, distance);
    }

    @Override
    public int fare() {
        return getDistance() * 5; // Bike fare = 5 per km
    }

    public void printBike() {
        System.out.println(info() + " Type: Bike");
    }
}
