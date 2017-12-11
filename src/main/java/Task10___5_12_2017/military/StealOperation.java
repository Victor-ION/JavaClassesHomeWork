package Task10___5_12_2017.military;

/**
 * Первая военная задача.
 * Темной-темной ночью прапорщики Иванов, Петров и Нечепорчук
 * занимаются хищением военного имущества со склада родной военной части.
 * Будучи умными людьми и отличниками боевой и строевой подготовки, прапорщики ввели разделение труда:
 * Иванов выносит имущество со склада,
 * Петров грузит его в грузовик,
 * а Нечепорчук подсчитывает рыночную стоимость добычи.
 */
public class StealOperation {


    public static void main(String[] args) {
        Ivanov i = new Ivanov();
        Petrov p = new Petrov(i.getFromStorage());
        Necheporchuk n = new Necheporchuk(p.getLorry());

        Thread t1 = new Thread(i);
        Thread t2 = new Thread(p);
        Thread t3 = new Thread(n);

        t1.start();
        t2.start();
        t3.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t1.interrupt();
        t2.interrupt();
        t3.interrupt();
    }
}
