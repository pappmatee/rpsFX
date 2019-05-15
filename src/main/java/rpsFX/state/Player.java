package rpsFX.state;

/**
 * Class representing the player.
 */
public class Player {

    /**
     * The name of the player.
     */
    private String name;

    /**
     * The choice made by the player.
     */
    private Choice choice;

    /**
     * The score collected by the player.
     */
    private int score;

    /**
     * Class constructor specifying name of player to create.
     * @param name the name of the player
     */
    public Player(String name) {
        this.name = name;
    }

    /**
     * Returns the name of the player.
     * @return name the name of the player
     */
    public String getName() {
        return name;
    }

    /**
     *  Sets the name of the player.
     * @param name the name of the player
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns choice made by the player.
     * @return choice made by the player
     */
    public Choice getChoice() {
        return choice;
    }

    /**
     * Sets the choice for the player.
     * @param choice the choice for the player to made
     */
    public void setChoice(Choice choice) {
        this.choice = choice;
    }

    /**
     * Returns the score collected by the player.
     * @return score collected by the player
     */
    public int getScore() {
        return score;
    }

    /**
     * Sets the score for the player.
     * @param score the score for the player to set
     */
    public void setScore(int score) {
        this.score = score;
    }
}
