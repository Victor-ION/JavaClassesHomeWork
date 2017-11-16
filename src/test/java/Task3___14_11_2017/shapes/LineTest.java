package Task3___14_11_2017.shapes;

import org.junit.Test;

import static org.junit.Assert.*;

public class LineTest {
    @Test
    public void getLength() throws Exception {
        Line line = new Line(new Point(1,2), new Point(4,6));
        assertEquals(line.getLength(), 5, 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public  void setColorNegativeValue(){
        ColorLine line = new ColorLine(new Point(1, 2), new Point(3, 4), -1);

    }

}