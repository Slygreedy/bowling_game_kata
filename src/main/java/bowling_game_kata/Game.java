package bowling_game_kata;

public class Game {

    private int roll = 0;
    private int[] rolls = new int[21];



    public void roll(int pinsDown) {
        rolls[roll++] = pinsDown;
    }

    public int score() {
        int score = 0;
        int counter =0;

        for (int frame = 0; frame < 10; frame++) {
            if (isStrike(rolls[counter])) {
                score += getStrike(counter);
                counter++;
            }
            else if (isSpare(counter)){
                score += getSpare(counter);
                counter+=2;
            } else {
                score += getScore(counter);
                counter += 2;
            }
        }

        return score;
    }

    private int getStrike(int counter) {
        return rolls[counter] + rolls[counter + 1] + rolls[counter + 2];
    }

    private int getSpare(int counter) {
        return rolls[counter] + rolls[counter + 1] + rolls[counter + 2];
    }

    private int getScore(int counter) {
        return rolls[counter] + rolls[counter + 1];
    }

    private boolean isStrike(int roll) {
        return roll == 10;
    }

    private boolean isSpare(int counter) {
        return rolls[counter] + rolls[counter + 1] == 10;
    }


}
