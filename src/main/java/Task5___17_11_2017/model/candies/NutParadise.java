package Task5___17_11_2017.model.candies;

import java.util.Map;

public class NutParadise extends Candy{
    public NutParadise(Map<Component, Double> componentsMap) {
        super(componentsMap);
    }

    public NutParadise(Component[] componentsList) {
        super(componentsList);
    }

    public NutParadise(Component comp, double weight) {
        super(comp, weight);
    }

    public NutParadise(Component comp) {
        super(comp);
    }

    @Override
    public void addSpecialComponent() {
        super.addSpecialComponent();
        addComponent(Component.NUTS);
        addComponent(Component.MILK_CHOCOLATE);
        addComponent(Component.WAFFLE, 2.0);
    }
}
