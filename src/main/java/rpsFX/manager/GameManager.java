package rpsFX.manager;

import rpsFX.state.Player;

/**
 * Class managing the game.
 */
///CLOVER:OFF
public class GameManager {

    /**
     * Manages the the current round and sets the score for the specified player.
     * @param player the player whose score is needed
     * @param enemy the player whose score is neded
     */
    public void manageGame(Player player, Player enemy) {

        int playerScore = 0;
        int enemyScore = 0;

        int result = RoundManager.processRound(player, enemy);

        switch (result) {
            case 0:
                playerScore = player.getScore();
                enemyScore = enemy.getScore();
                break;
            case 1:
                playerScore = player.getScore() + 1;
                player.setScore(playerScore);
                break;
            case -1:
                enemyScore = enemy.getScore() + 1;
                enemy.setScore(enemyScore);
                break;
        }
    }

    /**
     * Decides the match is finished under the number of rounds.
     * @param player the player whose score is needed
     * @param enemy the player whose score is needed
     * @param roundNum the number of rounds
     * @return false if the game is not finished;
     * true if the game is finished
     */
    public boolean isFinished(Player player, Player enemy, int roundNum) {
        if (player.getScore() + enemy.getScore() != roundNum) {
            return false;
        }
        return true;
    }
}
///CLOVER:ON
