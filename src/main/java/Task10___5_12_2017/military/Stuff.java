package Task10___5_12_2017.military;

public class Stuff {
    private static int idCounter = 0;
    private final int id;
    private final int price;

    public Stuff() {
        id = ++idCounter;
        price = (int)(Math.random()*1000);
        System.out.println("stuff #" + id + " appearing (price = " + price + ")");
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Stuff{" +
                "id=" + id +
                ", price=" + price +
                '}';
    }
}
