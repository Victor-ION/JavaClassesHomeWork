package Task5___17_11_2017.model.candies;

import java.util.Map;

public class RoshChocMilk extends RoshChoc {
    public RoshChocMilk(Map<Component, Double> componentsMap) {
        super(componentsMap);
    }

    public RoshChocMilk(Component[] componentsList) {
        super(componentsList);
    }

    public RoshChocMilk(Component comp, double weight) {
        super(comp, weight);
    }

    public RoshChocMilk(Component comp) {
        super(comp);
    }

    @Override
    public void addSpecialComponent() {
        super.addSpecialComponent();
        addComponent(Component.MILK_CHOCOLATE, 100);
    }
}