package Task3___14_11_2017.shapes;

import org.junit.Test;

import static org.junit.Assert.*;

public class TriangleTest {
    @Test
    public void getArea() throws Exception {
        Triangle triangle = new Triangle(new Point(0,0), new Point(0,3), new Point(4,0));
        assertEquals(triangle.getArea(), 6.0, 0.001);
    }

    @Test
    public void isCorrect_WithUncorrectTriangle() throws Exception {
        Triangle incorrectTriangle = new Triangle(new Point(0,0), new Point(1,2), new Point(2,4));
        assertFalse(incorrectTriangle.isCorrect());
    }

    @Test
    public void isCorrect_WithCorrectTriangle() throws Exception{
        Triangle triangle = new Triangle(new Point(0,0), new Point(0,3), new Point(4,0));
        assertTrue(triangle.isCorrect());
    }

    @Test
    public void getPerimeter() throws Exception {
        Triangle triangle = new Triangle(new Point(0,0), new Point(0,3), new Point(4,0));
        assertEquals(triangle.getPerimeter(), 12.0, 0.001);
    }

}