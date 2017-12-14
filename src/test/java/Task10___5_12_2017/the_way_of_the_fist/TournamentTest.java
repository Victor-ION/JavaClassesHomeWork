package Task10___5_12_2017.the_way_of_the_fist;

import org.junit.Test;

import static org.junit.Assert.*;

public class TournamentTest {
    @Test
    public void getWinner() throws Exception {
        Monk[] monks = {
                new Monk(Temple.INN, 5),
                new Monk(Temple.YAN, 10)
        };
        Monk winner = Tournament.getWinner(monks);
        assertTrue(winner.getTemple()==Temple.YAN);

    }

    @Test
    public void getBattleWinner() throws Exception {
        Monk m1 = new Monk(Temple.INN, 5);
        Monk m2 = new Monk(Temple.YAN, 10);
        Monk winner = Tournament.getBattleWinner(m1, m2);
        assertTrue(winner.getTemple()==Temple.YAN);
    }

}