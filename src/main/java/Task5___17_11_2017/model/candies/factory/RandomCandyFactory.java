package Task5___17_11_2017.model.candies.factory;

import Task5___17_11_2017.model.candies.*;

import java.util.Map;

public class RandomCandyFactory extends AbstractCandyFactory {
    @Override
    public Candy getElement() {
        int i = ((int) (Math.random() * 9)) + 1;
        return getElement(i);
    }

    public Candy getElement(int typeNumber) {
        if (typeNumber < 0 || typeNumber > 9) throw new IllegalArgumentException("incorrect number");
        Map<Component, Double> map = ComponentsGenerator.generateComponentsMap();
        switch (typeNumber) {
            case 1:
                return new Candy(map);
            case 2:
                return new CoronaMilkChoc(map);
            case 3:
                return new HappyCake(map);
            case 4:
                return new JellyBelly(map);
            case 5:
                return new NutParadise(map);
            case 6:
                return new RoshChoc(map);
            case 7:
                return new RoshChocMilk(map);
            case 8:
                return new WomboCombo(map);
            case 9:
                return new WomboComboExtraChoc(map);
        }
        return null;
    }
}
