package Task5___17_11_2017.model.candies;

import java.util.Map;

public class WomboComboExtraChoc extends WomboCombo{
    public WomboComboExtraChoc(Map<Component, Double> componentsMap) {
        super(componentsMap);
    }

    public WomboComboExtraChoc(Component[] componentsList) {
        super(componentsList);
    }

    public WomboComboExtraChoc(Component comp, double weight) {
        super(comp, weight);
    }

    public WomboComboExtraChoc(Component comp) {
        super(comp);
    }

    @Override
    public void addSpecialComponent() {
        super.addSpecialComponent();
        addComponent(Component.MILK_CHOCOLATE, 10);
        addComponent(Component.DARK_CHOCOLATE, 10);
    }
}
