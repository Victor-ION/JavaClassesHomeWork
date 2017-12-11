package Task10___5_12_2017.military;

import java.math.BigInteger;
import java.util.*;

public class Necheporchuk implements Runnable {
    private List<Stuff> lorry = new LinkedList<>();
    private BigInteger sum = new BigInteger("0");

    public Necheporchuk(List<Stuff> lorry) {
        this.lorry = lorry;
    }


    @Override
    public void run() {
        synchronized (lorry) {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    while (lorry.isEmpty()) {
                        lorry.wait();
                    }

                    Stuff someStuff = lorry.remove(0);
                    sum = sum.add(new BigInteger(someStuff.getPrice() + ""));

                    System.out.println("Necheporchuk count the price of the stuff (" + someStuff.getId() + ")");
                }
            } catch (InterruptedException e) {
            } finally {
                System.out.println("At least we get sum = " + sum);

            }

        }
    }
}
