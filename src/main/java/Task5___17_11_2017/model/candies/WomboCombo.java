package Task5___17_11_2017.model.candies;

import java.util.Map;

public class WomboCombo extends Candy{
    public WomboCombo(Map<Component, Double> componentsMap) {
        super(componentsMap);
    }

    public WomboCombo(Component[] componentsList) {
        super(componentsList);
    }

    public WomboCombo(Component comp, double weight) {
        super(comp, weight);
    }

    public WomboCombo(Component comp) {
        super(comp);
    }

    @Override
    public void addSpecialComponent() {
        super.addSpecialComponent();
        addComponent(Component.MILK_CHOCOLATE);
        addComponent(Component.DARK_CHOCOLATE);
        addComponent(Component.NOUGAT);
        addComponent(Component.JELLY);
        addComponent(Component.CARAMEL);
        addComponent(Component.BISCUIT);
        addComponent(Component.WAFFLE);
        addComponent(Component.NUTS);
        addComponent(Component.COOKIE);
    }
}
