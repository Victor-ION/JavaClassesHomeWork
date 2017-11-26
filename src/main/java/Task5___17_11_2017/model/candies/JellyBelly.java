package Task5___17_11_2017.model.candies;

import java.util.Map;

public class JellyBelly extends Candy{

    public JellyBelly(Map<Component, Double> componentsMap) {
        super(componentsMap);
    }

    public JellyBelly(Component[] componentsList) {
        super(componentsList);
    }

    public JellyBelly(Component comp, double weight) {
        super(comp, weight);
    }

    public JellyBelly(Component comp) {
        super(comp);
    }

    @Override
    public void addSpecialComponent() {
        super.addSpecialComponent();
        addComponent(Component.JELLY, 10);
        addComponent(Component.BISCUIT, 10);
    }

}
