package Task5___17_11_2017.model.candies;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CandyTest {
    Candy candy;
    @Before
    public void initCandy(){
        candy = new Candy(Component.JELLY, 3).addComponent(Component.MILK_CHOCOLATE, 8);
        candy.addComponent(Component.NUTS);
    }



    @Test
    public void addComponent() throws Exception {
        candy.addComponent(Component.BISCUIT, 3);
        assertTrue(candy.getComponentsMap().containsKey(Component.BISCUIT));
        assertEquals(3.0, candy.getComponentsMap().get(Component.BISCUIT), 0.001 );
    }

    @Test
    public void addComponentWithoutWeightParam() throws Exception {
        candy.addComponent(Component.BISCUIT);
        assertTrue(candy.getComponentsMap().containsKey(Component.BISCUIT));
        assertEquals(5.0, candy.getComponentsMap().get(Component.BISCUIT), 0.001 );
    }

    @Test
    public void removeComponent() throws Exception {
        candy.removeComponent(Component.JELLY, 4);
        assertFalse(candy.getComponentsMap().containsKey(Component.JELLY));
    }

    @Test
    public void removeComponentLess() throws Exception {
        candy.removeComponent(Component.JELLY, 1);
        assertEquals(2 ,candy.getComponentsMap().get(Component.JELLY), 0.001);
    }

    @Test
    public void removeComponentWithoutParam() throws Exception {
        candy.removeComponent(Component.JELLY);
        assertFalse(candy.getComponentsMap().containsKey(Component.JELLY));
    }

    @Test
    public void getWeight() throws Exception {
        assertEquals(16, candy.getWeight(), 0.001);
    }

    @Test
    public void getSugarWeight() throws Exception {
        assertEquals(5.39, candy.getSugarWeight(), 0.001);
    }

    @Test
    public void getName() throws Exception {
        candy = new RoshChoc(Component.BISCUIT);
        assertEquals("RoshChoc", candy.getName());
    }

}