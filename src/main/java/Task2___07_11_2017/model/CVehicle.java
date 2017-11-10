package Task2___07_11_2017.model;

public abstract class CVehicle {
    private int x, y, z;

    // "цена"
    private double price;
    //"скорость"
    private double velocity;
    //"год выпуска"
    private int yearOfIssue;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getVelocity() {
        return velocity;
    }

    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }

    public int getYearOfIssue() {
        return yearOfIssue;
    }

    public void setYearOfIssue(int yearOfIssue) {
        this.yearOfIssue = yearOfIssue;
    }

    public CVehicle(int x, int y, int z, double price, double velocity, int yearOfIssue) {
        this.x = x;
        this.y = y;
        this.z = z;

        this.price = price;
        this.velocity = velocity;
        this.yearOfIssue = yearOfIssue;
    }
}
