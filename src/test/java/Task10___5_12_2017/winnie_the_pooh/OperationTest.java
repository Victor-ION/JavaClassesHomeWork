package Task10___5_12_2017.winnie_the_pooh;

import org.junit.Test;

import static org.junit.Assert.*;

public class OperationTest {
    @Test
    public void findBear() throws Exception {
        Operation operation = new Operation();
        operation.findBear();
        assertTrue(operation.isFind());
    }

    @Test
    public void giveSector() throws Exception {
        Operation operation = new Operation();
        operation.setForest(new boolean[0][0]);
        Gang g = new Gang(operation);
        operation.giveSector(g);
        assertEquals(-1, g.getSectorNumber());
    }

}