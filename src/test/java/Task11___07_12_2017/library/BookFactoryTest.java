package Task11___07_12_2017.library;

import org.junit.Test;

import static org.junit.Assert.*;

public class BookFactoryTest {
    @Test
    public void createBook() throws Exception {
        Book book = BookFactory.createBook();
        assertTrue(book!=null);
        assertTrue(book.getContent()!=null);
        assertTrue(book.getName()!=null);
    }

}