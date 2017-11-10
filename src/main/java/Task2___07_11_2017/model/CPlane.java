package Task2___07_11_2017.model;

import Task2___07_11_2017.RandomFieldGenerator;
import Task2___07_11_2017.model.Ables.Flyable;

public class CPlane extends CVehicle implements Flyable{
    private double height;
    private int passengers;

    public CPlane(int x, int y, int z, double price, double velocity, int yearOfIssue, double height, int passengers) {
        super(x, y, z, price, velocity, yearOfIssue);
        this.height = height;
        this.passengers = passengers;
    }

    public CPlane() {
        this(RandomFieldGenerator.getInt(0, 100),
                RandomFieldGenerator.getInt(0, 100),
                RandomFieldGenerator.getInt(0, 100),
                RandomFieldGenerator.getInt(1, 100000) * 1000,
                RandomFieldGenerator.getInt(500, 2000),
                RandomFieldGenerator.getInt(1990, 2017),
                RandomFieldGenerator.getInt(500, 7000),
                RandomFieldGenerator.getInt(2, 200)

        );
    }

    @Override
    public double fly() {
        return getVelocity();
    }

    @Override
    public String toString() {
        return "CPlane{" +
                "x=" + getX() +
                ", y=" + getY() +
                ", z=" + getZ() +
                ", price=" + getPrice() +
                ", velocity=" + getVelocity() +
                ", yearOfIssue=" + getYearOfIssue() +
                ", height=" + getHeight() +
                ", passengers=" + getPassengers() +
                '}';
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }
}
