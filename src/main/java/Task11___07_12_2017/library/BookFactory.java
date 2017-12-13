package Task11___07_12_2017.library;

import Task2___07_11_2017.RandomFieldGenerator;

public class BookFactory {
    public static Book createBook() {
        boolean isAvailableForHome = ((int) (Math.random() * 2)) >= 1;
        boolean isPresent = ((int) (Math.random() * 2)) >= 1;
        String name = RandomFieldGenerator.getCasualName();
        String content = RandomFieldGenerator.getName(20, 50);
        return new Book(isAvailableForHome, isPresent, name, content);
    }
}
