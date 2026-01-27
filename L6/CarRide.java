package L6;

public class CarRide extends Ride {

    public CarRide(String name, int distance) {
        super(name, distance);
    }

    @Override
    public int fare() {
        return getDistance() * 12; // Car fare = 12 per km
    }

    public void printCar() {
        System.out.println(info() + " Type: Car");
    }
}
