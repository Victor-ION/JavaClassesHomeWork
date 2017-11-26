package Task5___17_11_2017.model.candies;

import java.util.Map;

public class RoshChoc extends Candy {
    public RoshChoc(Map<Component, Double> componentsMap) {
        super(componentsMap);
    }

    public RoshChoc(Component[] componentsList) {
        super(componentsList);
    }

    public RoshChoc(Component comp, double weight) {
        super(comp, weight);
    }

    public RoshChoc(Component comp) {
        super(comp);
    }

    @Override
    public void addSpecialComponent() {
        super.addSpecialComponent();
        addComponent(Component.DARK_CHOCOLATE, 100);
    }
}
