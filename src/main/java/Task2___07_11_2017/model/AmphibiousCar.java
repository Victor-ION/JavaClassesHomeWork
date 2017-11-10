package Task2___07_11_2017.model;

import Task2___07_11_2017.model.Ables.Swimable;

public class AmphibiousCar extends CCar implements Swimable{
    public AmphibiousCar(int x, int y, int z, double price, double velocity, int yearOfIssue) {
        super(x, y, z, price, velocity, yearOfIssue);
    }

    public AmphibiousCar() {
        super();
    }

    @Override
    public double swim() {
        return getVelocity()/5;
    }

    @Override
    public String toString() {
        return "AmphibiousCar{" +
                "x=" + getX() +
                ", y=" + getY() +
                ", z=" + getZ() +
                ", price=" + getPrice() +
                ", velocity=" + getVelocity() +
                ", velocity(Swim)=" + getVelocity()/5  +
                ", yearOfIssue=" + getYearOfIssue() +
                '}';
    }
}
