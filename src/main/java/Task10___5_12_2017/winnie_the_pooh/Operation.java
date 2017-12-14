package Task10___5_12_2017.winnie_the_pooh;

/**
 *  Первая задача о Винни-Пухе, или неправильные пчелы.
 *  Неправильные пчелы, подсчитав в конце месяца убытки от наличия в лесу Винни-Пуха,
 *  решили разыскать его и наказать в назидание всем другим любителям сладкого.
 *  Для поисков медведя они поделили лес на участки, каждый из которых прочесывает одна стая неправильных пчел.
 *  В случае нахождения медведя на своем участке стая проводит показательное наказание и возвращается в улей.
 *  Если участок прочесан, а Винни-Пух на нем не обнаружен, стая также возвращается в улей.
 *  Требуется создать многопоточное приложение, моделирующее действия пчел.
 *  При решении использовать парадигму портфеля задач.
 */
public class Operation {
    private volatile boolean find = false;

    private boolean[][] forest= {
            {false, false, false, false},
            {false, false, false, false},
            {false, false, false, false},
            {false, false, false, false},
            {false, false, false, false},
            {false, false, false, false},
            {false, false, false, false},
            {false, false, false, false},
            {false, false, false, false},
            {false, false, false, false},
            {false, false, false, false},
            {false, false, false, false},
            {false, false, false, false},
            {false, false, true, false},
            {false, false, false, false},

    };

    public void setForest(boolean[][] forest) {
        this.forest = forest;
    }

    private int counter = 0;


    public static void main(String[] args) throws InterruptedException{
        Operation operation = new Operation();
        Gang gang1 = new Gang(operation);
        Gang gang2 = new Gang(operation);
        Gang gang3 = new Gang(operation);

        Thread thread1 = new Thread(gang1);
        Thread thread2 = new Thread(gang2);
        Thread thread3 = new Thread(gang3);

        System.out.println("Start!");
        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

        System.out.println();
        if (operation.find){
            System.out.println("At least bear was found and punished :)");
        }
        else System.out.println("at least bear wasn't found and punished :(");



    }

    public synchronized boolean isFind() {
        return find;
    }

    public synchronized void findBear() {
        this.find = true;

    }

    /**
     * synchronized method for getting special area for gang cycle
     * @return boolean array
     */
    public synchronized void giveSector(Gang g) {
        if (counter == forest.length){
            g.setSector(null);
            g.setSectorNumber(-1);
        }
        else {
            g.setSectorNumber(counter);
            g.setSector(forest[counter++]);
        }
    }
}
