package Task8___28_11_2017;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {
    private Calculator calculator;
    @Before
    public void init(){
        calculator = new Calculator();
    }
    @Test
    public void calculate() throws Exception {
        String res = calculator.calculate("3+7*2-2");
        assertEquals(15.0, Double.parseDouble(res), 0.01);
    }

    @Test
    public void addOuterPar() throws Exception {
        assertEquals("(4+3)", calculator.addOuterPar("4+3"));
    }

}