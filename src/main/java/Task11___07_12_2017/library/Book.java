package Task11___07_12_2017.library;

import java.io.Serializable;

public class Book implements Serializable {
    private static int idCounter = 0;
    private final int id;
    private boolean isAvailableForHome;
    private volatile boolean isPresent;
    private final String name;
    private final String content;


    public Book(boolean isAvailableForHome, boolean isPresent, String name, String content) {
        this.id = ++idCounter;
        this.isAvailableForHome = isAvailableForHome;
        this.isPresent = isPresent;
        this.name = name;
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        return id == book.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public String getContent() {
        return content;
    }


    public boolean isAvailableForHome() {
        return isAvailableForHome;
    }


    public synchronized boolean isPresent() {
        return isPresent;
    }

    public synchronized void setPresent(boolean present) {
        isPresent = present;
    }

}
