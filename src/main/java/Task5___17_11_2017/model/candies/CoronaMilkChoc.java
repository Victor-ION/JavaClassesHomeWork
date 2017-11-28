package Task5___17_11_2017.model.candies;

import java.util.Map;

public class CoronaMilkChoc extends Candy {
    public CoronaMilkChoc(Map<Component, Double> componentsMap) {
        super(componentsMap);
    }

    public CoronaMilkChoc(Component[] componentsList) {
        super(componentsList);
    }

    public CoronaMilkChoc(Component comp, double weight) {
        super(comp, weight);
    }

    public CoronaMilkChoc(Component comp) {
        super(comp);
    }

    @Override
    public void addSpecialComponent() {
        super.addSpecialComponent();
        addComponent(Component.MILK_CHOCOLATE);
    }
}
