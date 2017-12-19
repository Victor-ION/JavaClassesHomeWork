package Task_12___08_12_2017;

import Task_12___08_12_2017.dao.Book;

public class Demo {

    private static Connector connector;

    public static void main(String[] args) throws Exception{
        try {
            connector = new Connector("LibraryTask", "localhost", 3306);

//            connector.addBookToAuthorList("MyBook", 4, 1);


            Book book = connector.findBookByAuthorNameAndBookName(
                    "Alexandr", "Petrov", "MyBook");

            System.out.println();
            System.out.println(book);
            System.out.println();

//            connector.changeRatingForBook(book.getIdBook(), 5);

//            book = connector.findBookByAuthorNameAndBookName(
//                    "Alexandr", "Petrov", "MyBook");

//            System.out.println();
//            System.out.println(book);
//            System.out.println();


//            connector.removeBookFromAuthorList(book.getIdBook());

        } catch (Exception e) {
            e.printStackTrace();
            if (connector!=null) {
                connector.stop();
            }
        }

    }
}
