package Task11___07_12_2017.library;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Storage {
    private List<Book> books = new ArrayList<>();

    public Storage() {
        for (int i = 0; i <20; i++) {
            books.add(BookFactory.createBook());
        }
    }

    public List<Book> getBooks() {
        return books;
    }

    public synchronized void setBooks(List<Book> books) {
        this.books = books;
    }

    public Book getBook(int id){
        return books.get(id);
    }




}
