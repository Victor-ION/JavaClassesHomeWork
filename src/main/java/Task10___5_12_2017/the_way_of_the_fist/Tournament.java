package Task10___5_12_2017.the_way_of_the_fist;

import java.util.Arrays;
import java.util.concurrent.*;

/**
 * Задача о Пути Кулака.
 * На седых склонах Гималаев стоят два древних буддистских монастыря:
 * Гуань-Инь и Гуань-Янь.
 * Каждый год в день сошествия на землю боддисатвы Араватти
 * монахи обоих монастырей собираются на совместное празднество
 * и показывают свое совершенствование на Пути Кулака.
 * Всех соревнующихся монахов разбивают на пары,
 * победители пар бьются затем между собой и так далее, до финального поединка.
 * Монастырь, монах которого победил в финальном бою, забирает себе на хранение статую боддисатвы.
 * <p>
 * Реализовать многопоточное приложение, определяющего победителя.
 * В качестве входных данных используется массив, в котором хранится количество энергии Ци каждого монаха.
 * При решении использовать принцип дихотомии.
 */

public class Tournament implements Callable<Monk> {

    private static ExecutorService executorService = Executors.newFixedThreadPool(10);
    private Monk[] participants;

    public Tournament(Monk[] participants) {
        this.participants = participants;
    }


    public static void main(String[] args) {
        /**
         * initialize participants array
         */
        Monk[] initParticipants = new Monk[20];
        System.out.println("source array");
        for (int i = 0; i < 20; i++) {
            Temple temple = Temple.values()[(int) (Math.random() * 2)];
            int energytsi = (int) (Math.random() * 10);
            Monk rndMonk = new Monk(temple, energytsi);
            initParticipants[i] = rndMonk;
            System.out.println(rndMonk);
        }
        Tournament tournament = new Tournament(initParticipants);

        System.out.println();
        System.out.println("Start tournament!");
        Monk winner = getWinner(tournament.participants);
        System.out.println(winner);
        winner.getTemple().takeStatue();


    }

    @Override
    public Monk call() throws Exception {
        return getWinner(participants);
    }

    /**
     * the main method that divide task into 2 parts and invoke itself recursively
     *
     * @param participants
     * @return
     */
    public static Monk getWinner(Monk[] participants) {
        if (participants == null) throw new IllegalArgumentException("no participants!");
        switch (participants.length) {
            case 0:
                throw new IllegalArgumentException("no participants!");
            case 1:
                return participants[0];
            case 2:
                return getBattleWinner(participants[0], participants[1]);
            default: {
                FutureTask<Monk> futureTask1 = new FutureTask<Monk>(
                        new Tournament(Arrays.copyOfRange(participants, 0, participants.length / 2)));
                Thread t1 = new Thread(futureTask1);
                t1.start();

                FutureTask<Monk> futureTask2 = new FutureTask<Monk>(
                        new Tournament(Arrays.copyOfRange(participants, participants.length / 2 + 1, participants.length)));
                Thread t2 = new Thread(futureTask2);
                t2.start();

                Monk participant1 = null;
                Monk participant2 = null;
                try {
                    participant1 = futureTask1.get();
                    participant2 = futureTask2.get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
                return getBattleWinner(participant1, participant2);
            }
        }

    }

    /**
     * choose which of the monks are better, and change their energy according to the rules
     *
     * @param participant1
     * @param participant2
     * @return winner
     */
    public static Monk getBattleWinner(Monk participant1, Monk participant2) {
        if (participant1.getEnergyTsi() >= participant2.getEnergyTsi()) {
            participant1.setEnergyTsi(participant1.getEnergyTsi() + participant2.getEnergyTsi());
            participant2.setEnergyTsi(0);
            return participant1;
        } else {
            participant2.setEnergyTsi(participant2.getEnergyTsi() + participant1.getEnergyTsi());
            participant1.setEnergyTsi(0);
            return participant2;
        }
    }
}
