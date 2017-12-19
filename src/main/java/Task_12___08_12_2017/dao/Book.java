package Task_12___08_12_2017.dao;

public class Book {
    private int idBook;
    private String name;
    private int rating;
    private int idAuthor;
    private String authorFirstName;
    private String authorSecondName;

    @Override
    public String toString() {
        return "Book{" +
                "idBook=" + idBook +
                ", name='" + name + '\'' +
                ", rating=" + rating +
                ", idAuthor=" + idAuthor +
                ", authorName='" + authorFirstName + " " + authorSecondName + '\'' +
                '}';
    }

    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public void setAuthorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
    }

    public String getAuthorSecondName() {
        return authorSecondName;
    }

    public void setAuthorSecondName(String authorSecondName) {
        this.authorSecondName = authorSecondName;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(int idAuthor) {
        this.idAuthor = idAuthor;
    }
}
