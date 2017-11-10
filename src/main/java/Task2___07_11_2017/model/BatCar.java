package Task2___07_11_2017.model;

import Task2___07_11_2017.model.Ables.Flyable;

public class BatCar extends CCar implements Flyable {
    public BatCar(int x, int y, int z, double price, double velocity, int yearOfIssue) {
        super(x, y, z, price, velocity, yearOfIssue);
    }

    public BatCar() {
        super();
    }

    @Override
    public double fly() {
        return getVelocity()*2;
    }

    @Override
    public String toString() {
        return "BatCar{" +
                "x=" + getX() +
                ", y=" + getY() +
                ", z=" + getZ() +
                ", price=" + getPrice() +
                ", velocity=" + getVelocity() +
                ", velocity(Fly)=" + getVelocity()*2  +
                ", yearOfIssue=" + getYearOfIssue() +
                '}';
    }
}
