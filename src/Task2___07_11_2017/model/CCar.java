package Task2___07_11_2017.model;

import Task2___07_11_2017.RandomFieldGenerator;
import Task2___07_11_2017.model.Ables.Moveable;

public class CCar extends CVehicle implements Moveable{
    public CCar(int x, int y, int z, double price, double velocity, int yearOfIssue) {
        super(x, y, z, price, velocity, yearOfIssue);
    }

    public CCar() {
        this(RandomFieldGenerator.getInt(0, 100),
                RandomFieldGenerator.getInt(0, 100),
                RandomFieldGenerator.getInt(0, 100),
                RandomFieldGenerator.getInt(1, 100) * 1000,
                RandomFieldGenerator.getInt(40, 400),
                RandomFieldGenerator.getInt(1990, 2017)
        );
    }

    @Override
    public double move() {
        return getVelocity();
    }

    @Override
    public String toString() {
        return "CCar{" +
                "x=" + getX() +
                ", y=" + getY() +
                ", z=" + getZ() +
                ", price=" + getPrice() +
                ", velocity=" + getVelocity() +
                ", yearOfIssue=" + getYearOfIssue() +
                '}';
    }
}
