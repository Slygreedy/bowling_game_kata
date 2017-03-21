import static org.junit.Assert.*;

import bowling_game_kata.Game;
import org.junit.Ignore;
import org.junit.Test;

public class BowlingGameTest {

    private Game game = new Game();

    @Test
    public void gutterGame() throws Exception {
        rollMany(20, 0);
        assertEquals(0, game.score());
    }

    @Test
    public void allOnes() throws Exception {
        rollMany(20, 1);
        assertEquals(20, game.score());
    }

    @Test
    public void canRollSpare() throws Exception {
        rollSpare();
        game.roll(3);
        rollMany(17, 0);
        assertEquals(16, game.score());
    }

    @Test
    public void canRollStrike () throws Exception {
        rollStrike(10);
        game.roll(5);
        game.roll(3);
        rollMany(16, 0);
        assertEquals(26, game.score());
    }

    @Test
    public void perfectGame() throws Exception {
        rollMany(12, 10);
        assertEquals(300, game.score());
    }

    private void rollStrike(int pins) {
        game.roll(pins);
    }

    private void rollSpare() {
        game.roll(5);
        game.roll(5);
    }

    private void rollMany(int n, int pins) {
        for (int i = 0; i < n; i++)
        {
            game.roll(pins);
        }
    }
}
