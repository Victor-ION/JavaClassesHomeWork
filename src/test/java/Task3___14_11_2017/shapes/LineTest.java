package Task3___14_11_2017.shapes;

import org.junit.Test;

import static org.junit.Assert.*;

public class LineTest {
    @Test
    public void getLength() throws Exception {
        Line line = new Line(new Point(1,2), new Point(4,6));
        assertEquals(line.getLength(), 5, 0.001);
    }

}