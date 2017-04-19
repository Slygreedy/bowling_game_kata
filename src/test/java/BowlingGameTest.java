import bowling_game_kata.Game;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BowlingGameTest {

    private Game game;

    @Before
    public void initialisation() {
       game = new Game();
    }

    @Test
    public void canScoreGutterGame() {
        rollMany(0, 20);
        assertThat(game.score(), is(0));
    }

    @Test
    public void canScoreAllOnes() {
        rollMany(1, 20);
        assertThat(game.score(), is(20));
    }

    @Test
    public void canRollSpareFollowedByThree() {
        game.roll(5);
        game.roll(5);
        game.roll(3);
        rollMany(0, 17);
        assertThat(game.score(), is (16));
    }

    @Test
    public void canRollStrikeFollowedByThreeAndFour() {
        game.roll(10);
        game.roll(3);
        game.roll(4);
        rollMany(0, 16);
        assertThat(game.score(), is(24));
    }

    @Test
    public void canRollPerfectGame() {
        rollMany(10, 20);
        assertThat(game.score(), is (300));
    }

    public void rollMany(int pins, int rolls) {
        for(int i = 0; i < rolls; i++) {
            game.roll(pins);
        }
    }

}

