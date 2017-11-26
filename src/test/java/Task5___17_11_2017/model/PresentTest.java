package Task5___17_11_2017.model;

import Task5___17_11_2017.model.candies.Candy;
import Task5___17_11_2017.model.candies.Component;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PresentTest {
    Present present;

    @Before
    public void initPresent() {
        present = new Present(0);
        ArrayList<Candy> list = new ArrayList<>();
        list.add(new Candy(Component.CARAMEL, 1));  // 0.51*1 = 0.51 sugar
        list.add(new Candy(Component.BISCUIT, 3));  // 0.02*3 = 0.06 sugar
        list.add(new Candy(Component.JELLY, 2));    // 0.13*2 = 0.26 sugar
        present.setCandyList(list);
    }

    @Test
    public void sortByWeightAsc() throws Exception {
        present.sortByWeight(true);
        assertTrue(present.getCandyList().get(0).getComponentsMap().containsKey(Component.CARAMEL)
                && present.getCandyList().get(0).getComponentsMap().size() == 1);
        assertTrue(present.getCandyList().get(1).getComponentsMap().containsKey(Component.JELLY)
                && present.getCandyList().get(1).getComponentsMap().size() == 1);
        assertTrue(present.getCandyList().get(2).getComponentsMap().containsKey(Component.BISCUIT)
                && present.getCandyList().get(2).getComponentsMap().size() == 1);
    }

    @Test
    public void sortByWeightDesc() throws Exception {
        present.sortByWeight(false);
        assertTrue(present.getCandyList().get(0).getComponentsMap().containsKey(Component.BISCUIT)
                && present.getCandyList().get(0).getComponentsMap().size() == 1);
        assertTrue(present.getCandyList().get(1).getComponentsMap().containsKey(Component.JELLY)
                && present.getCandyList().get(1).getComponentsMap().size() == 1);
        assertTrue(present.getCandyList().get(2).getComponentsMap().containsKey(Component.CARAMEL)
                && present.getCandyList().get(2).getComponentsMap().size() == 1);
    }

    @Test
    public void sortBySugarContentAsc() throws Exception {
        present.sortBySugarWeight(true);

        assertTrue(present.getCandyList().get(0).getComponentsMap().containsKey(Component.BISCUIT)
                && present.getCandyList().get(0).getComponentsMap().size() == 1);
        assertTrue(present.getCandyList().get(1).getComponentsMap().containsKey(Component.JELLY)
                && present.getCandyList().get(1).getComponentsMap().size() == 1);
        assertTrue(present.getCandyList().get(2).getComponentsMap().containsKey(Component.CARAMEL)
                && present.getCandyList().get(2).getComponentsMap().size() == 1);
    }

    @Test
    public void sortBySugarContentDesc() throws Exception {
        present.sortBySugarWeight(false);
        assertTrue(present.getCandyList().get(0).getComponentsMap().containsKey(Component.CARAMEL)
                && present.getCandyList().get(0).getComponentsMap().size() == 1);
        assertTrue(present.getCandyList().get(1).getComponentsMap().containsKey(Component.JELLY)
                && present.getCandyList().get(1).getComponentsMap().size() == 1);
        assertTrue(present.getCandyList().get(2).getComponentsMap().containsKey(Component.BISCUIT)
                && present.getCandyList().get(2).getComponentsMap().size() == 1);
    }

    @Test
    public void getCandiesWithSpecialRangeOfSugarContent() throws Exception {
        List<Candy> list = present.getCandiesWithSpecialRangeOfSugarWeight(0.2, 0.4);
        assertTrue(list.size() == 1);
        assertTrue(list.get(0).getComponentsMap().containsKey(Component.JELLY)
                && list.get(0).getComponentsMap().size() == 1);
    }

}