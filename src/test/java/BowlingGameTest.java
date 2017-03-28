import static org.junit.Assert.*;

import bowling_game_kata.Game;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class BowlingGameTest {

    private Game game;

    @Before
    public void initialise() {
        game = new Game();
    }

    @Test
    public void canRollGutterGame() {

        rollMany(0, 20);

        assertEquals(0, game.getScore());
    }

    @Test
    public void canRollAllOnes() {

        rollMany(1, 20);

        assertEquals(20, game.getScore());
    }

    @Test
    public void canRollSpare() {
        game.roll(5);
        game.roll(5);
        game.roll(3);
        rollMany(0, 17);
        assertEquals(16, game.getScore());
    }

    @Test
    public void canRollStrike() {
        game.roll(10);
        game.roll(4);
        game.roll(3);
        rollMany(0, 16);
        assertEquals(24, game.getScore());
    }

    @Test
    public void canRollPerfectGame() {
        rollMany(10, 12);
        assertEquals(300, game.getScore());
    }

    private void rollMany(int pins, int rolls) {
        for (int i = 0; i < rolls; i++) {
            game.roll(pins);
        }
    }


}
