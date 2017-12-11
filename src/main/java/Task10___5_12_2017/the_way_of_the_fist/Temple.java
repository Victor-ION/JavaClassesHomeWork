package Task10___5_12_2017.the_way_of_the_fist;

public enum Temple {
    INN,
    YAN;

    public void takeStatue(){
        System.out.println(toString() + " get the Statue! Congratulations!");
    }

    @Override
    public String toString() {
        return "Temple - " +name();
    }
}
