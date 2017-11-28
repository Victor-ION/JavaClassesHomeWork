package Task5___17_11_2017.model.candies;

import java.util.HashMap;
import java.util.Map;

public class Candy implements Componentable {
    private Map<Component, Double> componentsMap = new HashMap<>();
    private Double weight;
    private Double sugarWeight;

    public Map<Component, Double> getComponentsMap() {
        return componentsMap;
    }

    public void setComponentsMap(Map<Component, Double> componentsMap) {
        this.componentsMap = componentsMap;
        changed();
    }

    /**
     * used when componentsMap was changed
     */
    public void changed() {
        setWeight(null);
        setSugarWeight(null);
    }

    /**
     * to add component to map
     *
     * @param comp   source
     * @param weight source
     * @return this Candy obj
     */
    public Candy addComponent(Component comp, double weight) {
        if (comp == null) throw new IllegalArgumentException("No component");
        if (weight == 0) throw new IllegalArgumentException("0 component weight");
        if (componentsMap.containsKey(comp)) {
            weight += componentsMap.get(comp);
        }
        componentsMap.put(comp, weight);

        changed();
        return this;
    }

    /**
     * to add component to map with default weight
     *
     * @param comp source
     * @return this Candy obj
     */
    public Candy addComponent(Component comp) {
        if (comp == null) throw new IllegalArgumentException("No component");
        if (componentsMap.containsKey(comp)) {
            setWeight(getWeight() + componentsMap.get(comp));
        }
        componentsMap.put(comp, 5.0);
        changed();
        return this;
    }

    /**
     * remove special weight of component
     *
     * @param component obj
     * @param weight    if more than weight of component at the moment, remove component at all
     * @return this Candy object
     */
    public Candy removeComponent(Component component, double weight) {
        if (component == null) throw new IllegalArgumentException("No component");
        if (!componentsMap.containsKey(component))
            throw new IllegalArgumentException("Component wasn't include in candy");
        if (weight == 0) throw new IllegalArgumentException("0 component weight");
        double dif = componentsMap.get(component) - weight;
        if (dif <= 0) {
            removeComponent(component);
        } else {
            componentsMap.put(component, dif);
        }

        changed();
        return this;
    }

    /**
     * remove special component from componentsMap
     *
     * @param component obj
     * @return this Candy object
     */
    public Candy removeComponent(Component component) {
        if (component == null) throw new IllegalArgumentException("No component");
        if (!componentsMap.containsKey(component))
            throw new IllegalArgumentException("Component wasn't include in candy");
        componentsMap.remove(component);

        changed();
        return this;
    }


    /**
     * Constructors
     */


    public Candy(Map<Component, Double> componentsMap) {
        if (componentsMap.isEmpty()) throw new IllegalArgumentException("No Components");
        this.componentsMap = componentsMap;
        addSpecialComponent();
        checkHasComponents();
    }

    public Candy(Component[] componentsList) {
        if (componentsList.length == 0) throw new IllegalArgumentException("No Components");
        for (Component component : componentsList) {
            addComponent(component);
        }
        addSpecialComponent();
        checkHasComponents();
    }

    public Candy(Component comp, double weight) {
        addComponent(comp, weight);
        addSpecialComponent();
        checkHasComponents();
    }

    public Candy(Component comp) {
        addComponent(comp);
        addSpecialComponent();
        checkHasComponents();
    }


    @Override
    public void addSpecialComponent() {
        // empty, this method for classes that extends Candy
    }


    public Double getWeight() {
        if (weight == null) {
            weight = calculateWeight();
        }
        return weight;
    }

    public void checkHasComponents() {
        if (componentsMap.isEmpty()) throw new IllegalArgumentException("Candy should have at least one component");
    }

    /**
     * summarize weight of each component
     *
     * @return weight of candy
     */
    private Double calculateWeight() {
        double res = 0;
        for (Map.Entry<Component, Double> entry : componentsMap.entrySet()) {
            res += entry.getValue();
        }
        return res;

    }

    public Double getSugarWeight() {
        if (sugarWeight == null) {
            sugarWeight = calculateSugarWeight();
        }
        return sugarWeight;
    }

    /**
     * calculate sugar weight in each component by multiplying weight on component.sugarWeight
     * and summarize all results
     *
     * @return weight of sugar in candy
     */
    private Double calculateSugarWeight() {
        double res = 0;
        for (Map.Entry<Component, Double> entry : componentsMap.entrySet()) {
            double current = entry.getValue();
            current *= entry.getKey().getSugarContent();
            res += current;
        }
        return res;
    }


    @Override
    public String toString() {
        return "" + getName() + " { \n" +
                stringMap(componentsMap)
                + "weight=" + getWeight() +
                ", sugarWeight=" + getSugarWeight() +
                '}';
    }

    public String stringMap(Map<Component, Double> componentsMap) {
        StringBuilder sb = new StringBuilder("Components : [[\n");
        for (Map.Entry<Component, Double> entry : componentsMap.entrySet()) {
            sb.append("\t" + entry.getKey().toString() + " - " + entry.getValue() + "g\n");
        }
        sb.append(" ]] \n");
        return sb.toString();
    }

    public String getName() {
        return this.getClass().getSimpleName();
    }


    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public void setSugarWeight(Double sugarWeight) {
        this.sugarWeight = sugarWeight;
    }


}
