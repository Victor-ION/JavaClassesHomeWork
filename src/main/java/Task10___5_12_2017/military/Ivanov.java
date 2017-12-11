package Task10___5_12_2017.military;

import java.util.*;

public class Ivanov implements Runnable {

    private List<Stuff> fromStorage = new LinkedList<>();

    public List<Stuff> getFromStorage() {
        return fromStorage;
    }

    public void setFromStorage(List<Stuff> fromStorage) {
        this.fromStorage = fromStorage;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                Stuff someStuff = getStuff();
                Thread.sleep(1000);
                synchronized (fromStorage) {
                    fromStorage.add(someStuff);
                    System.out.println("Ivanov bring stuff from the storage (" + someStuff.getId() + ")");
                    fromStorage.notify();
                }
            }
        } catch (InterruptedException e) {
        } finally {
            System.out.println("Ivanov is running out");


        }
    }

    private Stuff getStuff() {
        return new Stuff();
    }
}
