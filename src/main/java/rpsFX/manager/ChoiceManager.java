package rpsFX.manager;

import rpsFX.state.Choice;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Class comparing the choices by the players.
 */
public class ChoiceManager {

    private static final List<Choice> CHOICES = Arrays.asList(Choice.values());
    private static final Random RANDOM = new Random();

    /**
     * If the player plays against the computer a random choice is generated.
     * Returns a random choice for the computer's turn
     * @return a random choice
     */
    public static Choice isComputer() {
        return CHOICES.get(RANDOM.nextInt(CHOICES.size()));
    }

    /**
     * Decides which player wins the round.
     * @param player the choice made by the player
     * @param enemy the choice made by the enemy
     * @return -1 if the choice made by the enemy player beats the choice made by the player;
     * 1 if the choice made by the player beats the choice made by the computer;
     * 0 if the player and the enemy player made the same choice
     */
    public static int compareChoices (Choice player, Choice enemy) {

        if (player.getLoseAgainst() == enemy) //comp wins
            return -1;
        if (player.getWinAgainst() == enemy) //user wins
            return 1;
        return 0;

    }
}
