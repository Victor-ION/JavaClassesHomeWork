package Task_12___08_12_2017;

import Task_12___08_12_2017.dao.Book;

import java.sql.*;

public class Connector {

    private Connection connection = null;
//    private Statement statement = null;

    public void stop() throws SQLException {
        connection.close();
    }

    public Connector(String DBName, String ip, int port) throws Exception {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        String url = "jdbc:mysql://" + ip + ":" + port + "/" + DBName;

        connection = DriverManager.getConnection(url, "root", "root");
//        statement = connection.createStatement();

        System.out.println("connecting to DB was successful");

    }


    public boolean addBookToAuthorList(String bookName, int rating, int idAuthor) {
        try {
            String sql = "INSERT INTO books (bookName, rating, idAuthor) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, bookName);
            preparedStatement.setInt(2, rating);
            preparedStatement.setInt(3, idAuthor);

            preparedStatement.execute();
            System.out.println("book " + bookName + " was successfully added!");
            return true;
        } catch (SQLException e) {
            System.out.println("can't perform adding book " + bookName + " : " + e.getMessage());
            return false;
        }
    }

    public boolean removeBookFromAuthorList(int idBook) {
        try {
            String sql = "DELETE FROM books WHERE idBook = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idBook);
            preparedStatement.execute();
            System.out.println("book with id=" + idBook + " was successfully remove");
            return true;
        } catch (SQLException e) {
            System.out.println("can't perform deleting book with id=" + idBook + " : " + e.getMessage());
            return false;
        }
    }

    public boolean changeRatingForBook(int idBook, int newRating) {
        try {
            String sql = "UPDATE books SET rating= ? WHERE idBook = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, newRating);
            preparedStatement.setInt(2, idBook);
            preparedStatement.execute();

            System.out.println("book with id=" + idBook + " has new rating = " + newRating);
            return true;
        } catch (SQLException e) {
            System.out.println("can't perform updating book with id= " + idBook + " : " + e.getMessage());
            return false;
        }
    }

    public Book findBookByAuthorNameAndBookName(String authorFirstName, String authorSecondName, String bookName){
        Book book = new Book();
        try {
//            String sql = "SELECT books.idBook, books.bookName, books.rating, authors.idAuthor, authors.firstName, authors.secondName" +
            String sql = "SELECT *" +
                    "FROM LibraryTask.authors JOIN LibraryTask.books ON authors.idAuthor=books.idAuthor" +
                    "WHERE firstName = ? AND secondName = ? AND bookName = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, authorFirstName);
            preparedStatement.setString(2, authorSecondName);
            preparedStatement.setString(3, bookName);
            preparedStatement.execute();
            System.out.println("dddd");

            ResultSet rs = preparedStatement.getResultSet();
//            String sql = "SELECT *" +
//                    "FROM authors INNER JOIN books ON authors.idAuthor=books.idAuthor" +
//                    "WHERE secondName = '"+ authorSecondName+"' AND bookName = '"+ bookName+"'";
//            Statement statement = connection.createStatement();
//            statement.execute(sql);
//            ResultSet rs = statement.getResultSet();

            rs.next();
            book.setIdBook(rs.getInt("idBook"));
            book.setName(rs.getString("bookName"));
            book.setRating(rs.getInt("rating"));
            book.setIdAuthor(rs.getInt("idAuthor"));
            book.setAuthorFirstName(rs.getString("firstName"));
            book.setAuthorSecondName(rs.getString("secondName"));

            System.out.println("book was successfully found!");


        } catch (SQLException e){
            System.out.println("can't find book with: author name = " + authorFirstName +
                    " " + authorSecondName + ", book name = " + bookName + ".  reason: " + e.getMessage());
        }
        return book;
    }
}

