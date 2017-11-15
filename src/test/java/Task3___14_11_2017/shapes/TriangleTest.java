package Task3___14_11_2017.shapes;

import org.junit.Test;

import static org.junit.Assert.*;

public class TriangleTest {
    @Test
    public void getArea() throws Exception {
        Triangle triangle = UtilTriangleTest.SIMPLE_TRIANGLE;
        assertEquals(triangle.getArea(), UtilTriangleTest.AREA, UtilTriangleTest.DELTA);
    }

    @Test
    public void isCorrect_WithUncorrectTriangle() throws Exception {
        Triangle triangle = UtilTriangleTest.INCORRECT_TRIANGLE;
        assertFalse(triangle.isCorrect());
    }

    @Test
    public void isCorrect_WithCorrectTriangle() throws Exception{
        Triangle triangle = UtilTriangleTest.SIMPLE_TRIANGLE;
        assertTrue(triangle.isCorrect());
    }

    @Test
    public void getPerimeter() throws Exception {
        Triangle triangle = UtilTriangleTest.SIMPLE_TRIANGLE;
        assertEquals(triangle.getPerimeter(), UtilTriangleTest.PERIMETER, UtilTriangleTest.DELTA);
    }

}