package rpsFX.state;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Class representing the Leaderboard.
 */
public class Leaderboard {
    /**
     * The nickname of the player.
     */
    public SimpleStringProperty nickname = new SimpleStringProperty("");

    /**
     * The score collected by the player.
     */
    public SimpleIntegerProperty score = new SimpleIntegerProperty();

    /**
     * Class constructor specifying the data to be stored.
     * @param nickname the name of the player.
     * @param score the score collected by the player.
     */
    public Leaderboard(String nickname, int score) {
        setNickname(nickname);
        setScore(score);
    }

    /**
     * Empty constructor.
     */
    public Leaderboard() {
        this("",0);
    }


    /**
     * Returns the player's nickname.
     * @return the player's nickname.
     */
    public String getNickname() {
        return nickname.get();
    }

    /**
     * Sets the player's nickname.
     * @param nickname the player's nickname.
     */
    public void setNickname(String nickname) {
        this.nickname = new SimpleStringProperty(nickname);
    }

    /**
     * Returns the score collected by the player.
     * @return the score collected by the player.
     */
    public int getScore() {
        return score.get();
    }

    /**
     * Sets the score for the player.
     * @param score the score for the player to set.
     */
    public void setScore(int score) {
        this.score = new SimpleIntegerProperty(score);
    }

}
