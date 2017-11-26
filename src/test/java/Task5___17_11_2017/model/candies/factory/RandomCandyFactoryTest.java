package Task5___17_11_2017.model.candies.factory;

import Task5___17_11_2017.model.candies.Candy;
import org.junit.Test;

import static org.junit.Assert.*;

public class RandomCandyFactoryTest {
    @Test
    public void getElement() throws Exception {
        for (int i = 1; i <10; i++){

            RandomCandyFactory factory = new RandomCandyFactory();
            Candy candy = factory.getElement(i);
//        System.out.println(candy);
            assertTrue(candy instanceof Candy);
        }
    }

    @Test
    public void getElementWithoutParam(){
        RandomCandyFactory factory = new RandomCandyFactory();
        Candy candy = factory.getElement();
        assertTrue(candy instanceof Candy);

    }

}