package L6;

public class Ride {
    private String name;
    private int distance;

    public Ride(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public void setDistance(int distance) {
        if (distance < 0) distance = 0;
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

    public int fare() {
        return distance * 10; // base fare
    }

    protected String info() {
        return "Name: " + name + " Distance: " + distance + " Fare: " + fare();
    }

    public void print() {
        System.out.println(info());
    }
}
