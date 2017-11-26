package Task5___17_11_2017.model.candies.factory;

import Task5___17_11_2017.model.candies.Component;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class ComponentsGeneratorTest {
    @Test
    public void generateComponentsMap() throws Exception {
        Map<Component, Double> map = ComponentsGenerator.generateComponentsMap(5);
        assertEquals(5, map.size());

        for (Map.Entry<Component, Double> entry : map.entrySet()) {
            System.out.println(entry.getKey().toString() + " - " + entry.getValue() + "g");
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void generateComponentsMapWithIllegalAmount() {
        ComponentsGenerator.generateComponentsMap(Component.values().length + 1);
    }

    @Test
    public void generateComponentsMapWithNoAmount(){
        for (int i = 0; i< 20; i++){

            Map map = ComponentsGenerator.generateComponentsMap();
            assertTrue(map.size()>0);
            assertTrue(map.size()<=Component.values().length);
        }
    }

}