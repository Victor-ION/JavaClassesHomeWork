package Task11___07_12_2017.library;

import com.google.gson.Gson;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.*;

public class LibrarianTest {
    @Test
    public void sendBookAsJson() throws Exception {
        Book book = BookFactory.createBook();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream outputStream = new DataOutputStream(byteArrayOutputStream);
        Librarian.sendBookAsJson(book, outputStream);
//        System.out.println(new String(byteArrayOutputStream.toByteArray()));
        Gson gson = new Gson();
        Book bookCopy = gson.fromJson(new DataInputStream(
                new ByteArrayInputStream(byteArrayOutputStream.toByteArray())).readUTF(), Book.class);
//        System.out.println(book);
//        System.out.println(bookCopy);
        assertEquals(book, bookCopy);
    }

}