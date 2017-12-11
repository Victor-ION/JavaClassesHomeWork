package Task10___5_12_2017.military;

import java.util.*;

public class Petrov implements Runnable {
    private List<Stuff> fromStorage = new LinkedList<>();
    private List<Stuff> lorry = new LinkedList<>();

    public List<Stuff> getLorry() {
        return lorry;
    }

    public Petrov(List<Stuff> fromStorage) {
        this.fromStorage = fromStorage;
    }

    @Override
    public void run() {

        synchronized (fromStorage) {
            try {
                while (!Thread.currentThread().isInterrupted()) {

                    while (fromStorage.isEmpty()) {
                        fromStorage.wait();
                    }
                    Stuff someStuff = fromStorage.remove(0);

                    System.out.println("Petrov take stuff from Ivanov (" + someStuff.getId() + ")");
                    Thread.sleep(550);

                    synchronized (lorry) {
                        Thread.sleep(550);
                        lorry.add(someStuff);
                        System.out.println("Petrov put staff in the lorry (" + someStuff.getId() + ")");
                        lorry.notify();
                    }


                }

            } catch (InterruptedException e) {

            } finally {
                System.out.println("Petrov is running out!");

            }

        }

    }
}
