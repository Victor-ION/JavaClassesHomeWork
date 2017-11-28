package Task5___17_11_2017.model.candies;

import java.util.Map;

public class HappyCake extends Candy {
    public HappyCake(Map<Component, Double> componentsMap) {
        super(componentsMap);
    }

    public HappyCake(Component[] componentsList) {
        super(componentsList);
    }

    public HappyCake(Component comp, double weight) {
        super(comp, weight);
    }

    public HappyCake(Component comp) {
        super(comp);
    }

    @Override
    public void addSpecialComponent() {
        super.addSpecialComponent();
        addComponent(Component.BISCUIT, 50);
        addComponent(Component.CARAMEL, 10);
        addComponent(Component.NOUGAT, 10);
        addComponent(Component.MILK_CHOCOLATE, 10);
    }
}
