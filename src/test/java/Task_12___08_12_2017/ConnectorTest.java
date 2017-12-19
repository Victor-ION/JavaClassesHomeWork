package Task_12___08_12_2017;

import Task_12___08_12_2017.dao.Book;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class ConnectorTest {

    @Test
    public void testCycle(){
        Connector connector = null;
        try {
            connector = new Connector("LibraryTask", "localhost", 3306);

            connector.addBookToAuthorList("MyBook", 4, 1);


            Book book = connector.findBookByAuthorNameAndBookName(
                    "Alexandr", "Petrov", "MyBook");


            connector.changeRatingForBook(book.getIdBook(), 5);

            book = connector.findBookByAuthorNameAndBookName(
                    "Alexandr", "Petrov", "MyBook");



            connector.removeBookFromAuthorList(book.getIdBook());

        } catch (Exception e) {
            e.printStackTrace();

        }
        finally {
            if (connector!=null) {
                try {
                    connector.stop();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
    }

}