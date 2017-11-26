package Task5___17_11_2017.model.candies.factory;

import Task5___17_11_2017.model.candies.Component;

import java.util.HashMap;
import java.util.Map;

public class ComponentsGenerator {
    public static Map<Component, Double> generateComponentsMap(int amount){
        if (amount>Component.values().length) throw new IllegalArgumentException("amount of components that is needed is bigger than number of all components");

        Map<Component, Double> res = new HashMap<>(amount);
        for (int i = 0; i <amount; i++){

            int ordinal = (int)(Math.random()*9);
            Component comp = Component.values()[ordinal];

            // to avoid adding the same component
            if (res.containsKey(comp)){
                i--;
                continue;
            }

            //generate double in range of 1-10
            double weight = (int)(Math.random()*9 +1);

            res.put(comp, weight);
        }
        return res;
    }

    public static Map<Component, Double> generateComponentsMap(){
        return generateComponentsMap( (int)(Math.random()*(Component.values().length) +1) );

    }
}
