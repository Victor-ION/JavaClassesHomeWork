package Task9___30_11_2017.model;

import Task9___30_11_2017.exceptions.IllegalPreciousnessException;
import Task9___30_11_2017.exceptions.InvalidValueException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GemTest {
    private Gem gem;
    @Before
    public void setUp() throws Exception {
        gem = new Gem();
    }

    @Test
    public void setPreciousness() throws Exception {
        gem.setPreciousness("semiprecious");
    }
    @Test(expected = IllegalPreciousnessException.class)
    public void setPreciousnessIncorrect() throws Exception {
        gem.setPreciousness("semipreciouss");
    }

    @Test
    public void setValue() throws Exception {
        gem.setValue("12");
    }
    @Test(expected = InvalidValueException.class)
    public void setValueIncorrect() throws Exception {
        gem.setValue("dfdf");
    }

}