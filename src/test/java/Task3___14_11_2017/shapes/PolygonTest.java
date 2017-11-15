package Task3___14_11_2017.shapes;

import org.junit.Test;

import static org.junit.Assert.*;

public class PolygonTest {
    @Test
    public void getPerimeter() throws Exception {
        Polygon polygon = new Polygon(new Point(0,0), new Point(0,3), new Point(3,3), new Point(3,0));
        assertEquals(polygon.getPerimeter(), 12.0, 0.001);
    }

}