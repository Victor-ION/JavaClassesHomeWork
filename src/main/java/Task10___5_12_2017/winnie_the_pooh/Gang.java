package Task10___5_12_2017.winnie_the_pooh;

public class Gang implements Runnable{
    private static int counter = 0;
    private int id;
    private Operation operation;
    private boolean[] sector;
    private int sectorNumber;

    public Gang(Operation operation) {
        id = ++counter;
        this.operation = operation;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()&&!operation.isFind()){
            operation.giveSector(this);
            if (sector == null) break;
            System.out.println("Gang " + id + " starting to process the sector № " + sectorNumber);
            for (boolean b : sector){
                if (b) {
                    operation.findBear();
                    System.out.println("Bear was found at sector № " + sectorNumber + " !");
                    System.out.println("Punishing him!");
                    break;
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Gang " + id + " finished processing at the sector № " + sectorNumber);

        }

    }

    public boolean[] getSector() {
        return sector;
    }

    public void setSector(boolean[] sector) {
        this.sector = sector;
    }

    public int getSectorNumber() {
        return sectorNumber;
    }

    public void setSectorNumber(int sectorNumber) {
        this.sectorNumber = sectorNumber;
    }
}
