package Task2___07_11_2017.model;

import Task2___07_11_2017.RandomFieldGenerator;
import Task2___07_11_2017.model.Ables.Swimable;

public class CShip extends CVehicle implements Swimable{
    private String port;
    private int passengers;

    public CShip(int x, int y, int z, double price, double velocity, int yearOfIssue, String port, int passengers) {
        super(x, y, z, price, velocity, yearOfIssue);
        this.port = port;
        this.passengers = passengers;
    }

    public CShip() {
        this(RandomFieldGenerator.getInt(0, 100),
                RandomFieldGenerator.getInt(0, 100),
                RandomFieldGenerator.getInt(0, 100),
                RandomFieldGenerator.getInt(1, 100000) * 1000,
                RandomFieldGenerator.getInt(20, 100),
                RandomFieldGenerator.getInt(1980, 2017),
                RandomFieldGenerator.getCasualName(),
                RandomFieldGenerator.getInt(2, 1000)

        );
    }

    @Override
    public double swim() {
        return getVelocity();
    }

    @Override
    public String toString() {
        return "CShip{" +
                "x=" + getX() +
                ", y=" + getY() +
                ", z=" + getZ() +
                ", price=" + getPrice() +
                ", velocity=" + getVelocity() +
                ", yearOfIssue=" + getYearOfIssue() +
                ", port=" + getPort() +
                ", passengers=" + getPassengers() +
                '}';
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }
}
