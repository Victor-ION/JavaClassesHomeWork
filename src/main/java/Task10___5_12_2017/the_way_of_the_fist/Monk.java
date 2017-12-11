package Task10___5_12_2017.the_way_of_the_fist;

public class Monk {
    private final Temple temple;
    private int energyTsi;

    public int getEnergyTsi() {
        return energyTsi;
    }

    public void setEnergyTsi(int energyTsi) {
        this.energyTsi = energyTsi;
    }

    public Temple getTemple() {
        return temple;
    }

    public Monk(Temple temple, int energyTsi) {
        this.temple = temple;
        this.energyTsi = energyTsi;
    }

    @Override
    public String toString() {
        return "Monk{" +
                "temple=" + temple +
                ", energyTsi=" + energyTsi +
                '}';
    }
}
